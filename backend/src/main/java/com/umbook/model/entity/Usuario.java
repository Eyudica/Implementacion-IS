package com.umbook.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(
        name = "usuarios"
)
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Usuario {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nombre;
    private String apellido;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    @Column(
            unique = true
    )
    private String nombreUsuario;
    private String contrasena;
    private LocalDate fechaNacimiento;
    public boolean activo;
    private int diasCumpleanosConfig;

    static boolean $default$activo() {
        return true;
    }

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public int getDiasCumpleanosConfig() {
        return this.diasCumpleanosConfig;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(final String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setNombreUsuario(final String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(final String contrasena) {
        this.contrasena = contrasena;
    }

    public void setFechaNacimiento(final LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setActivo(final boolean activo) {
        this.activo = activo;
    }

    public void setDiasCumpleanosConfig(final int diasCumpleanosConfig) {
        this.diasCumpleanosConfig = diasCumpleanosConfig;
    }

    public Usuario() {
        this.activo = $default$activo();
    }

    public Usuario(final Long id, final String nombre, final String apellido, final String email, final String nombreUsuario, final String contrasena, final LocalDate fechaNacimiento, final boolean activo, final int diasCumpleanosConfig) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
        this.diasCumpleanosConfig = diasCumpleanosConfig;
    }
}