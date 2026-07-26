package com.umbook.service;

import com.umbook.exception.ExistentRequestException;
import com.umbook.exception.UsuarioNotFoundException;
import com.umbook.model.entity.SolicitudAmistad;
import com.umbook.model.entity.Usuario;
import com.umbook.model.enums.EstadoSolicitud;
import com.umbook.model.enums.TipoNotificacion;
import com.umbook.repository.SolicitudAmistadRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class SolicitudAmistadService {
    private final SolicitudAmistadRepository solicitudRepository;
    private final NotificacionService notificacionService;
    private final UsuarioService usuarioService;

    public SolicitudAmistad enviarSolicitud(Usuario remitente, Long destinatarioId) {
        Usuario destinatario = this.usuarioService.findById(destinatarioId);
        if (destinatario == null) {
            throw new UsuarioNotFoundException(destinatarioId);
        } else {
            this.solicitudRepository.findByRemitenteAndDestinatario(remitente, destinatario).ifPresent((s) -> {
                throw new ExistentRequestException("Ya hay una solicitud pendiente o ya son amigos");
            });
            String token = this.generarTokenEmail();
            SolicitudAmistad solicitud = SolicitudAmistad.builder().remitente(remitente).destinatario(destinatario).estado(EstadoSolicitud.PENDIENTE).tokenEmail(token).build();
            solicitud.enviar();
            SolicitudAmistad guardada = (SolicitudAmistad)this.solicitudRepository.save(solicitud);
            this.notificacionService.crearNotificacion(destinatario, TipoNotificacion.SOLICITUD_AMISTAD, guardada.getId());
            return guardada;
        }
    }

    public String generarTokenEmail() {
        return UUID.randomUUID().toString();
    }

    public SolicitudAmistadService(final SolicitudAmistadRepository solicitudRepository, final NotificacionService notificacionService, final UsuarioService usuarioService) {
        this.solicitudRepository = solicitudRepository;
        this.notificacionService = notificacionService;
        this.usuarioService = usuarioService;
    }
}