package com.umbook.repository;

import com.umbook.model.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
}