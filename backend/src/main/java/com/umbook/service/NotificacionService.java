package com.umbook.service;

import com.umbook.model.entity.Notificacion;
import com.umbook.model.entity.Usuario;
import com.umbook.model.enums.TipoNotificacion;
import com.umbook.repository.NotificacionRepository;
import com.umbook.repository.SolicitudAmistadRepository;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {
    private final NotificacionRepository notificacionRepository;
    private final JavaMailService mailService;
    private final SolicitudAmistadRepository solicitudAmistadRepository;

    public void crearNotificacion(Usuario destinatario, TipoNotificacion tipo, Long referenciaId) {
        Notificacion notificacion = Notificacion.builder().destinatario(destinatario).tipo(tipo).referenciaId(referenciaId).leida(false).build();
        this.notificacionRepository.save(notificacion);
        if (tipo == TipoNotificacion.SOLICITUD_AMISTAD && referenciaId != null) {
            Optional var10000 = this.solicitudAmistadRepository.findById(referenciaId);
            JavaMailService var10001 = this.mailService;
            Objects.requireNonNull(var10001);
            var10000.ifPresent(var10001::enviarEmailSolicitudAmistad);
        }

    }

    public NotificacionService(final NotificacionRepository notificacionRepository, final JavaMailService mailService, final SolicitudAmistadRepository solicitudAmistadRepository) {
        this.notificacionRepository = notificacionRepository;
        this.mailService = mailService;
        this.solicitudAmistadRepository = solicitudAmistadRepository;
    }
}