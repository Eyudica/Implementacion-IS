package com.umbook.service;

import com.umbook.model.entity.SolicitudAmistad;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JavaMailService {
    private final JavaMailSender mailSender;

    public void enviarEmailSolicitudAmistad(SolicitudAmistad solicitud) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(solicitud.getDestinatario().getEmail());
            message.setSubject("Nueva Solicitud de Amistad en UMBook");
            String var10001 = solicitud.getDestinatario().getNombre();
            message.setText("Hola " + var10001 + ",\n\n" + solicitud.getRemitente().getNombre() + " " + solicitud.getRemitente().getApellido() + " te ha enviado una solicitud de amistad.\n\nLink de confirmación: " + solicitud.generarLinkEmail());
            this.mailSender.send(message);
        } catch (Exception var3) {
            System.out.println("[JavaMailService] Simulación email enviado a: " + solicitud.getDestinatario().getEmail());
        }

    }

    public JavaMailService(final JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}