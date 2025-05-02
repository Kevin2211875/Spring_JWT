// js/proveedores.js
console.log("Página cargada, token disponible:", localStorage.getItem('accessToken'));


function renderProveedores(proveedores) {
    const tableBody = document.getElementById('proveedor-table');
    tableBody.innerHTML = ''; // Limpia la tabla

    proveedores.forEach(proveedor => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${proveedor.id}</td>
            <td>${proveedor.nit}</td>
            <td>${proveedor.nombre}</td>
            <td>${proveedor.ciudad}</td>
            <td>${proveedor.telefono}</td>
            <td>${proveedor.direccion}</td>
        `;
        tableBody.appendChild(row);
    });
}

const token = localStorage.getItem('accessToken');

async function loadData() {

    try {
        console.log("Antes del fetch, token:", localStorage.getItem('accessToken'));
        window.addEventListener('beforeunload', () => {
            console.log("¡La página se está recargando o cerrando!");
        });
        
        const response = await fetch('http://localhost:8080/proveedores', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json'
            }
        });
        window.addEventListener('beforeunload', () => {
            console.log("¡La página se está recargando o cerrando!");
        });
        


        if (!response.ok) {
            throw new Error(`Error HTTP: ${response.status}`);
        }

        const proveedores = await response.json();
        renderProveedores(proveedores);
    } catch (error) {
        console.error('Error:', error);
        alert('Error al cargar proveedores: ' + error.message);
    }
}

function saveProveedor() {
    const token = localStorage.getItem('accessToken');
    if (!token) {
        alert('No estás autenticado.');
        return;
    }

    const proveedor = {
        nit: document.getElementById('proveedor-nit').value,
        nombre: document.getElementById('proveedor-nombre').value,
        ciudad: document.getElementById('proveedor-ciudad').value,
        telefono: document.getElementById('proveedor-telefono').value,
        direccion: document.getElementById('proveedor-direccion').value
    };

    const proveedorId = document.getElementById('proveedor-id').value;
    const method = proveedorId && proveedorId !== "" ? 'PUT' : 'POST';
    const url = method === 'PUT'
        ? `${API_BASE_URL}/proveedores/${proveedorId}`
        : `${API_BASE_URL}/proveedores/crearProveedores`;

    fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify(proveedor)
    })
    .then(response => {
        if (response.ok) {
            alert('Proveedor guardado correctamente');
            window.location.href = 'login.html';
        } else {
            return response.json().then(error => { throw new Error(error.message); });
        }
    })
    .catch(error => {
        alert('Error: ' + error.message);
    });
}


function deleteProveedor() {
    const token = localStorage.getItem('accessToken');
    if (!token) {
        alert('No estás autenticado.');
        return;
    }

    const proveedorId = document.getElementById('proveedor-id').value;
    if (!proveedorId) {
        alert('No hay proveedor seleccionado para eliminar.');
        return;
    }

    if (!confirm('¿Estás seguro de que quieres eliminar este proveedor?')) {
        return;
    }

    fetch(`${API_BASE_URL}/proveedores/${proveedorId}`, {
        method: 'DELETE',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
    .then(response => {
        if (response.ok) {
            alert('Proveedor eliminado correctamente');
            window.location.href = 'list_proveedores.html';
        } else {
            return response.json().then(error => { throw new Error(error.message); });
        }
    })
    .catch(error => {
        alert('Error: ' + error.message);
    });
}



function loadProveedor(id) {
    const token = localStorage.getItem('accessToken');
    if (!token) {
        alert('No estás autenticado.');
        return;
    }

    fetch(`${API_BASE_URL}/proveedores/${id}`, {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Error al cargar el proveedor');
        }
    })
    .then(proveedor => {
        document.getElementById('proveedor-id').value = proveedor.id;
        document.getElementById('proveedor-nit').value = proveedor.nit;
        document.getElementById('proveedor-nombre').value = proveedor.nombre;
        document.getElementById('proveedor-ciudad').value = proveedor.ciudad;
        document.getElementById('proveedor-telefono').value = proveedor.telefono;
        document.getElementById('proveedor-direccion').value = proveedor.direccion;
    })
    .catch(error => {
        alert(error.message);
    });
}