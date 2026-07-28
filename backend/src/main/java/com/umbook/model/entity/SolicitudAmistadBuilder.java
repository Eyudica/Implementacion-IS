package com.umbook.model.entity;

import com.umbook.model.enums.EstadoSolicitud;
import java.time.LocalDateTime;

public class SolicitudAmistadBuilder {
    private Long id;
    private Usuario remitente;
    private Usuario destinatario;
    private boolean estado$set;
    public EstadoSolicitud estado;
    public boolean fechaEnvio;
    private LocalDateTime fechaEnvio$value;
    private String tokenEmail;

    SolicitudAmistadBuilder() {
    }

    public SolicitudAmistadBuilder id(final Long id) {
        this.id = id;
        return this;
    }

    public SolicitudAmistadBuilder remitente(final Usuario remitente) {
        this.remitente = remitente;
        return this;
    }

    public SolicitudAmistadBuilder destinatario(final Usuario destinatario) {
        this.destinatario = destinatario;
        return this;
    }

    public SolicitudAmistadBuilder estado(final EstadoSolicitud estado) {
        this.estado = estado;
        this.estado$set = true;
        return this;
    }

    public SolicitudAmistadBuilder fechaEnvio(final LocalDateTime fechaEnvio) {
        this.fechaEnvio$value = fechaEnvio;
        this.fechaEnvio = true;
        return this;
    }

    public SolicitudAmistadBuilder tokenEmail(final String tokenEmail) {
        this.tokenEmail = tokenEmail;
        return this;
    }

    public SolicitudAmistad build() {
        EstadoSolicitud estado = this.estado;
        if (!this.estado$set) {
            estado = SolicitudAmistad.$default$estado();
        }

        LocalDateTime fechaEnvio$value = this.fechaEnvio$value;
        if (!this.fechaEnvio) {
            fechaEnvio$value = SolicitudAmistad.$default$fechaEnvio();
        }

        return new SolicitudAmistad(this.id, this.remitente, this.destinatario, estado, fechaEnvio$value, this.tokenEmail);
    }

    public String toString() {
        Long var10000 = this.id;
        return "SolicitudAmistad.SolicitudAmistadBuilder(id=" + var10000 + ", remitente=" + String.valueOf(this.remitente) + ", destinatario=" + String.valueOf(this.destinatario) + ", estado=" + String.valueOf(this.estado) + ", fechaEnvio$value=" + String.valueOf(this.fechaEnvio$value) + ", tokenEmail=" + this.tokenEmail + ")";
    }
}