const API_BASE_URL = 'http://localhost:8080';

// Tabs Logic
document.querySelectorAll('.nav-btn').forEach(btn => {
    btn.addEventListener('click', () => {
        document.querySelectorAll('.nav-btn').forEach(b => b.classList.remove('active'));
        document.querySelectorAll('.tab-content').forEach(c => c.classList.remove('active'));
        
        btn.classList.add('active');
        document.getElementById(`tab-${btn.dataset.tab}`).classList.add('active');
    });
});

// CU-7: BuscadorUI -> GET /usuarios/buscar?nombre=X&apellido=Y
document.getElementById('form-buscar').addEventListener('submit', async (e) => {
    e.preventDefault();
    const nombre = document.getElementById('search-nombre').value;
    const apellido = document.getElementById('search-apellido').value;
    const resultsContainer = document.getElementById('results-buscar');

    try {
        const response = await fetch(`${API_BASE_URL}/usuarios/buscar?nombre=${encodeURIComponent(nombre)}&apellido=${encodeURIComponent(apellido)}`);
        const data = await response.json();

        if (data.length === 0) {
            resultsContainer.innerHTML = '<p class="empty-state">No se encontraron usuarios que coincidan con los criterios.</p>';
            return;
        }

        resultsContainer.innerHTML = data.map(user => `
            <div class="user-item">
                <div class="user-info">
                    <span class="user-name">ID: ${user.id} - ${user.nombre || ''} ${user.apellido || ''}</span>
                    <span class="user-email">${user.email} (${user.nombreUsuario || 'sin username'})</span>
                </div>
                <span class="badge ${user.activo ? 'badge-active' : 'badge-inactive'}">
                    ${user.activo ? 'Activo' : 'Deshabilitado'}
                </span>
            </div>
        `).join('');
    } catch (err) {
        resultsContainer.innerHTML = `<p class="alert-error">Error al conectar con el servidor backend: ${err.message}</p>`;
    }
});

// CU-6: PerfilUsuarioUI -> POST /solicitudes/enviar?destinatarioId=X
document.getElementById('form-solicitud').addEventListener('submit', async (e) => {
    e.preventDefault();
    const remitenteId = document.getElementById('remitente-id').value;
    const destinatarioId = document.getElementById('destinatario-id').value;
    const responseBox = document.getElementById('response-solicitud');

    try {
        const response = await fetch(`${API_BASE_URL}/solicitudes/enviar?destinatarioId=${destinatarioId}`, {
            method: 'POST',
            headers: {
                'X-Remitente-Id': remitenteId
            }
        });

        if (response.status === 201) {
            const data = await response.json();
            responseBox.innerHTML = `<p class="alert-success">✓ Solicitud de amistad enviada exitosamente. ID Solicitud: ${data.id}, Estado: ${data.estado}</p>`;
        } else if (response.status === 404) {
            responseBox.innerHTML = '<p class="alert-error">❌ Usuario no encontrado (404)</p>';
        } else if (response.status === 400) {
            responseBox.innerHTML = '<p class="alert-error">❌ Ya hay una solicitud pendiente o ya son amigos (400)</p>';
        } else {
            const text = await response.text();
            responseBox.innerHTML = `<p class="alert-error">❌ Error (${response.status}): ${text}</p>`;
        }
    } catch (err) {
        responseBox.innerHTML = `<p class="alert-error">Error de conexión: ${err.message}</p>`;
    }
});

// CU-5: UIAdminUsuarios -> PUT /admin/usuarios/deshabilitar?id=X
document.getElementById('form-deshabilitar').addEventListener('submit', async (e) => {
    e.preventDefault();
    const usuarioId = document.getElementById('usuario-id').value;
    const responseBox = document.getElementById('response-deshabilitar');

    try {
        const response = await fetch(`${API_BASE_URL}/admin/usuarios/deshabilitar?id=${usuarioId}`, {
            method: 'PUT'
        });

        if (response.status === 200) {
            responseBox.innerHTML = '<p class="alert-success">✓ Usuario deshabilitado exitosamente (200)</p>';
        } else if (response.status === 404) {
            responseBox.innerHTML = '<p class="alert-error">❌ Usuario no encontrado (404)</p>';
        } else {
            const text = await response.text();
            responseBox.innerHTML = `<p class="alert-error">❌ Error (${response.status}): ${text}</p>`;
        }
    } catch (err) {
        responseBox.innerHTML = `<p class="alert-error">Error de conexión: ${err.message}</p>`;
    }
});
