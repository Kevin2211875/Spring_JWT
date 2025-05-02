// Asegúrate de guardar el token correctamente después del login
request.onload = function() {
    let data1 = request.response;
    if (data1.accessToken) { // Asume que el backend devuelve { accessToken: "..." }
        localStorage.setItem('accessToken', data1.accessToken);
        window.location = 'menu.html';
    } else {
        alert('Error: No se recibió token');
    }
};