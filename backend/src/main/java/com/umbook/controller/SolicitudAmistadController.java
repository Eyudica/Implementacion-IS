package com.umbook.controller;

import com.umbook.exception.ExistentRequestException;
import com.umbook.exception.UsuarioNotFoundException;
import com.umbook.model.entity.SolicitudAmistad;
import com.umbook.model.entity.Usuario;
import com.umbook.service.SolicitudAmistadService;
import com.umbook.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestHeader; // removed per diagram
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/solicitudes"})
@CrossOrigin(
        origins = {"*"}
)
public class SolicitudAmistadController {
    private final SolicitudAmistadService solicitudService;
    private final UsuarioService usuarioService;

    @PostMapping({"/enviar"})
    public ResponseEntity<?> enviarSolicitud(@RequestParam("destinatarioId") Long destinatarioId, @RequestParam(value = "remitenteId", required = false, defaultValue = "1") Long remitenteId) {
        try {
            Usuario remitente = this.usuarioService.findById(remitenteId);
            SolicitudAmistad solicitud = this.solicitudService.enviarSolicitud(remitente, destinatarioId);
            return ResponseEntity.status(HttpStatus.CREATED).body(solicitud);
        } catch (UsuarioNotFoundException var5) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        } catch (ExistentRequestException var6) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ya hay una solicitud pendiente");
        } catch (com.umbook.exception.AlreadyFriendsException var7) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya son amigos");
        }
    }

    public SolicitudAmistadController(final SolicitudAmistadService solicitudService, final UsuarioService usuarioService) {
        this.solicitudService = solicitudService;
        this.usuarioService = usuarioService;
    }
}