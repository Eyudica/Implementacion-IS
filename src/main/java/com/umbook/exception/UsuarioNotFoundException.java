package com.umbook.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String message) {
        super(message);
    }

    public UsuarioNotFoundException(Long id) {
        super("Usuario no encontrado con id: " + id);
    }
}