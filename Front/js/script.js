
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
                const token = data.access_token;
                localStorage.setItem('accessToken', token);
                showMessage('Login exitoso!', true);    
                window.location.href = "login.html";
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
