
const API_BASE_URL = 'http://localhost:8080';

// 1. DEFINIR PRIMERO LAS FUNCIONES COMUNES
const showMessage = (message, isSuccess) => {
    const messageDiv = document.getElementById('message');
    if (messageDiv) {
        messageDiv.textContent = message;
        messageDiv.className = `message ${isSuccess ? 'success' : 'error'}`;
        messageDiv.style.display = 'block';
        
        setTimeout(() => {
            messageDiv.style.display = 'none';
        }, 5000);
    }
};

const storeTokens = (tokenResponse) => {
    localStorage.setItem('accessToken', tokenResponse.accessToken);
    if (tokenResponse.refreshToken) {
        localStorage.setItem('refreshToken', tokenResponse.refreshToken);
    }
};

const clearTokens = () => {
    localStorage.removeItem('accessToken');
    localStorage.removeItem('refreshToken');
};

const getAccessToken = () => {
    return localStorage.getItem('accessToken');
    
};

// 2. FUNCIÓN PARA OBTENER INFO DEL USUARIO
const fetchUserInfo = async () => {
    const token = getAccessToken();
    if (!token) return false;

    try {
        const response = await fetch(`${API_BASE_URL}/auth/me`, {
            headers: {
                'Authorization': `Bearer ${token}`,
                'Accept': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Failed to fetch user info');
        }

        const user = await response.json();
        
        if (user) {
            document.getElementById('userName').textContent = user.name;
            document.getElementById('userEmail').textContent = user.email;
            document.getElementById('userInfo').style.display = 'block';
            document.getElementById('loginForm').style.display = 'none';
            return true;
        }
    } catch (error) {
        console.error('Error:', error);
        showMessage('Error al cargar información del usuario', false);
        clearTokens();
        document.getElementById('loginForm').style.display = 'block';
        document.getElementById('userInfo').style.display = 'none';
    }
    return false;
};

// 3. MANEJADOR DE LOGIN
if (document.getElementById('loginForm')) {
    document.getElementById('loginForm').addEventListener('submit', async (e) => {
        e.preventDefault();
        
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        try {
            const response = await fetch(`${API_BASE_URL}/auth/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ email, password })
            });

            const data = await response.json();

            if (response.ok) {
                storeTokens(data);
                showMessage('Login exitoso!', true);
                await fetchUserInfo();
                window.location.href = "login.html";
                localStorage.setItem('accessToken', token);
            } else {
                showMessage(data.message || 'Error en login', false);
            }
        } catch (error) {
            showMessage('Error de conexión: ' + error.message, false);
        }
    });
}

// 4. MANEJADOR DE REGISTRO
if (document.getElementById('registerForm')) {
    document.getElementById('registerForm').addEventListener('submit', async (e) => {
        e.preventDefault();

        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        if (password !== confirmPassword) {
            showMessage('Las contraseñas no coinciden', false);
            return;
        }

        try {
            const response = await fetch(`${API_BASE_URL}/auth/register`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ name, email, password })
            });

            const data = await response.json();

            if (response.ok) {
                showMessage('Registro exitoso. Ahora puedes iniciar sesión.', true);
                setTimeout(() => {
                    window.location.href = "index.html"; // Redirige al login
                }, 3000);
            } else {
                showMessage(data.message || 'Error en registro', false);
            }
        } catch (error) {
            showMessage('Error de conexión: ' + error.message, false);
        }
    });
}

// 5. INICIALIZACIÓN
document.addEventListener('DOMContentLoaded', () => {
    if (getAccessToken()) {
        fetchUserInfo();
    }
});

// 6. MANEJADOR DE FORMULARIO DE PROVEEDORES
if (document.getElementById('form-proveedor')) {
    document.getElementById('form-proveedor').addEventListener('submit', async (e) => {
        e.preventDefault();
        
        const token = getAccessToken();
        if (!token) {
            showMessage('Debes iniciar sesión primero', false);
            window.location.href = 'index.html';
            return;
        }

        const proveedor = {
            id: document.getElementById('proveedor-id').value || null,
            nit: document.getElementById('proveedor-nit').value,
            nombre: document.getElementById('proveedor-nombre').value,
            ciudad: document.getElementById('proveedor-ciudad').value,
            telefono: document.getElementById('proveedor-telefono').value,
            direccion: document.getElementById('proveedor-direccion').value
        };

        try {
            const method = proveedor.id ? 'PUT' : 'POST';
            const url = proveedor.id ? 
                `${API_BASE_URL}/proveedores/${proveedor.id}` : 
                `${API_BASE_URL}/proveedores`;

            const response = await fetch(url, {
                method: method,
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify(proveedor)
            });

            const data = await response.json();

            if (response.ok) {
                showMessage('Proveedor guardado correctamente', true);
                setTimeout(() => {
                    window.location.href = 'login.html'; // Redirige a la tabla de proveedores
                }, 1500);
            } else {
                throw new Error(data.message || 'Error al guardar el proveedor');
            }
        } catch (error) {
            showMessage('Error: ' + error.message, false);
        }
    });
}

// 7. FUNCIÓN PARA ELIMINAR PROVEEDOR (global para que funcione el onclick)
window.deleteProveedor = async function() {
    const token = getAccessToken();
    if (!token) {
        showMessage('Debes iniciar sesión primero', false);
        window.location.href = 'index.html';
        return;
    }

    const proveedorId = document.getElementById('proveedor-id').value;
    if (!proveedorId) {
        showMessage('No hay proveedor seleccionado para eliminar', false);
        return;
    }

    if (!confirm('¿Estás seguro de que quieres eliminar este proveedor?')) {
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/proveedores/${proveedorId}`, {
            method: 'DELETE',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        });

        if (response.ok) {
            showMessage('Proveedor eliminado correctamente', true);
            setTimeout(() => {
                window.location.href = 'login.html'; // Redirige a la tabla de proveedores
            }, 1500);
        } else {
            const data = await response.json();
            throw new Error(data.message || 'Error al eliminar el proveedor');
        }
    } catch (error) {
        showMessage('Error: ' + error.message, false);
    }
}
