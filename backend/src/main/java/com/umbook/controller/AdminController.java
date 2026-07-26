package com.umbook.controller;

import com.umbook.exception.UsuarioNotFoundException;
import com.umbook.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/admin/usuarios"})
@CrossOrigin(
        origins = {"*"}
)
public class AdminController {
    private final AdminService adminService;

    @PutMapping({"/deshabilitar"})
    public ResponseEntity<?> deshabilitarUsuario(@RequestParam("id") Long id) {
        try {
            this.adminService.deshabilitarUsuario(id);
            return ResponseEntity.ok("Usuario deshabilitado");
        } catch (UsuarioNotFoundException var3) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    public AdminController(final AdminService adminService) {
        this.adminService = adminService;
    }
}