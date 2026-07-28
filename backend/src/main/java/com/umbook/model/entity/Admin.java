package com.umbook.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(
        name = "admins"
)
public class Admin extends Usuario {

    public void deshabilitarUsuario(Usuario usuarioId) {
        if (usuarioId != null) {
            usuarioId.setActivo(false);
        }
    }

    public Admin() {
        super();
    }

    public Admin(final Long id, final String nombre, final String apellido, final String email, final String nombreUsuario, final String contrasena, final LocalDate fechaNacimiento, final boolean activo, final int diasCumpleanosConfig) {
        super(id, nombre, apellido, email, nombreUsuario, contrasena, fechaNacimiento, activo, diasCumpleanosConfig);
    }
}
