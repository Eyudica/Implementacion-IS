package com.umbook.model.entity;

import java.time.LocalDate;

public class UsuarioBuilder {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String nombreUsuario;
    private String contrasena;
    private LocalDate fechaNacimiento;
    private boolean activo$set;
    private boolean activo$value;
    private int diasCumpleanosConfig;

    UsuarioBuilder() {
    }

    public UsuarioBuilder id(final Long id) {
        this.id = id;
        return this;
    }

    public UsuarioBuilder nombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder apellido(final String apellido) {
        this.apellido = apellido;
        return this;
    }

    public UsuarioBuilder email(final String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder nombreUsuario(final String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public UsuarioBuilder contrasena(final String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public UsuarioBuilder fechaNacimiento(final LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public UsuarioBuilder activo(final boolean activo) {
        this.activo$value = activo;
        this.activo$set = true;
        return this;
    }

    public UsuarioBuilder diasCumpleanosConfig(final int diasCumpleanosConfig) {
        this.diasCumpleanosConfig = diasCumpleanosConfig;
        return this;
    }

    public Usuario build() {
        boolean activo$value = this.activo$value;
        if (!this.activo$set) {
            activo$value = Usuario.$default$activo();
        }

        return new Usuario(this.id, this.nombre, this.apellido, this.email, this.nombreUsuario, this.contrasena, this.fechaNacimiento, activo$value, this.diasCumpleanosConfig);
    }

    public String toString() {
        Long var10000 = this.id;
        return "Usuario.UsuarioBuilder(id=" + var10000 + ", nombre=" + this.nombre + ", apellido=" + this.apellido + ", email=" + this.email + ", nombreUsuario=" + this.nombreUsuario + ", contrasena=" + this.contrasena + ", fechaNacimiento=" + String.valueOf(this.fechaNacimiento) + ", activo$value=" + this.activo$value + ", diasCumpleanosConfig=" + this.diasCumpleanosConfig + ")";
    }
}