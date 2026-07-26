package com.umbook.service;

import com.umbook.exception.UsuarioNotFoundException;
import com.umbook.model.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final UsuarioService usuarioService;

    public void deshabilitarUsuario(Long id) {
        Usuario usuario = this.usuarioService.findById(id);
        if (usuario == null) {
            throw new UsuarioNotFoundException(id);
        } else {
            this.usuarioService.deshabilitarUsuario(usuario.getId());
        }
    }

    public AdminService(final UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}