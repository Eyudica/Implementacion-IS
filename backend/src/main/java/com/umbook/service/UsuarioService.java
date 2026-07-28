package com.umbook.service;

import com.umbook.model.entity.Usuario;
import com.umbook.repository.UsuarioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public List<Usuario> buscarUsuarios(String nombre, String apellido) {
        return this.usuarioRepository.findByNombreContainingOrApellidoContaining(nombre, apellido);
    }

    public void deshabilitarUsuario(Long id) {
        Usuario usuario = this.findById(id);
        usuario.setActivo(false);
        this.usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id).orElse(null);
    }

    public UsuarioService(final UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}