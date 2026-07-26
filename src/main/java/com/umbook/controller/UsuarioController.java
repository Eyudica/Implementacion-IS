package com.umbook.controller;

import com.umbook.model.entity.Usuario;
import com.umbook.service.UsuarioService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/usuarios"})
@CrossOrigin(
        origins = {"*"}
)
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping({"/buscar"})
    public ResponseEntity<List<Usuario>> buscarUsuarios(@RequestParam(value = "nombre",required = false,defaultValue = "") String nombre, @RequestParam(value = "apellido",required = false,defaultValue = "") String apellido) {
        List<Usuario> resultados = this.usuarioService.buscarUsuarios(nombre, apellido);
        return ResponseEntity.ok(resultados);
    }

    public UsuarioController(final UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}