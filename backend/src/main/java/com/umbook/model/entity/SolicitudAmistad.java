package com.umbook.model.entity;

import com.umbook.model.enums.EstadoSolicitud;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "solicitudes_amistad"
)
public class SolicitudAmistad {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne(
            optional = false
    )
    @JoinColumn(
            name = "remitente_id"
    )
    private Usuario remitente;
    @ManyToOne(
            optional = false
    )
    @JoinColumn(
            name = "destinatario_id"
    )
    private Usuario destinatario;
    @Enumerated(EnumType.STRING)
    public EstadoSolicitud estado;
    public LocalDateTime fechaEnvio;
    private String tokenEmail;

    public void enviar() {
        this.estado = EstadoSolicitud.PENDIENTE;
        this.fechaEnvio = LocalDateTime.now();
    }

    public void aceptar() {
        this.estado = EstadoSolicitud.ACEPTADA;
    }

    public void rechazar() {
        this.estado = EstadoSolicitud.RECHAZADA;
    }

    public String generarLinkEmail() {
        return "https://umbook.com/solicitudes/confirmar?token=" + this.tokenEmail;
    }

    static EstadoSolicitud $default$estado() {
        return EstadoSolicitud.PENDIENTE;
    }

    static LocalDateTime $default$fechaEnvio() {
        return LocalDateTime.now();
    }

    public static SolicitudAmistadBuilder builder() {
        return new SolicitudAmistadBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Usuario getRemitente() {
        return this.remitente;
    }

    public Usuario getDestinatario() {
        return this.destinatario;
    }

    public EstadoSolicitud getEstado() {
        return this.estado;
    }

    public LocalDateTime getFechaEnvio() {
        return this.fechaEnvio;
    }

    public String getTokenEmail() {
        return this.tokenEmail;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setRemitente(final Usuario remitente) {
        this.remitente = remitente;
    }

    public void setDestinatario(final Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public void setEstado(final EstadoSolicitud estado) {
        this.estado = estado;
    }

    public void setFechaEnvio(final LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public void setTokenEmail(final String tokenEmail) {
        this.tokenEmail = tokenEmail;
    }

    public SolicitudAmistad() {
        this.estado = $default$estado();
        this.fechaEnvio = $default$fechaEnvio();
    }

    public SolicitudAmistad(final Long id, final Usuario remitente, final Usuario destinatario, final EstadoSolicitud estado, final LocalDateTime fechaEnvio, final String tokenEmail) {
        this.id = id;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.tokenEmail = tokenEmail;
    }
}