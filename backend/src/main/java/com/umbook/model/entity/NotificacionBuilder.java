package com.umbook.model.entity;

import com.umbook.model.enums.TipoNotificacion;
import java.time.LocalDateTime;

public class NotificacionBuilder {
    private Long id;
    private Usuario destinatario;
    private TipoNotificacion tipo;
    private boolean leida$set;
    private boolean leida$value;
    private boolean fechaCreacion$set;
    private LocalDateTime fechaCreacion$value;
    private Long referenciaId;

    NotificacionBuilder() {
    }

    public NotificacionBuilder id(final Long id) {
        this.id = id;
        return this;
    }

    public NotificacionBuilder destinatario(final Usuario destinatario) {
        this.destinatario = destinatario;
        return this;
    }

    public NotificacionBuilder tipo(final TipoNotificacion tipo) {
        this.tipo = tipo;
        return this;
    }

    public NotificacionBuilder leida(final boolean leida) {
        this.leida$value = leida;
        this.leida$set = true;
        return this;
    }

    public NotificacionBuilder fechaCreacion(final LocalDateTime fechaCreacion) {
        this.fechaCreacion$value = fechaCreacion;
        this.fechaCreacion$set = true;
        return this;
    }

    public NotificacionBuilder referenciaId(final Long referenciaId) {
        this.referenciaId = referenciaId;
        return this;
    }

    public Notificacion build() {
        boolean leida = this.leida$value;
        if (!this.leida$set) {
            leida = Notificacion.$default$leida();
        }

        LocalDateTime fechaCreacion$value = this.fechaCreacion$value;
        if (!this.fechaCreacion$set) {
            fechaCreacion$value = Notificacion.$default$fechaCreacion();
        }

        return new Notificacion(this.id, this.destinatario, this.tipo, leida$value, fechaCreacion$value, this.referenciaId);
    }

    public String toString() {
        Long var10000 = this.id;
        return "Notificacion.NotificacionBuilder(id=" + var10000 + ", destinatario=" + String.valueOf(this.destinatario) + ", tipo=" + String.valueOf(this.tipo) + ", leida$value=" + this.leida$value + ", fechaCreacion$value=" + String.valueOf(this.fechaCreacion$value) + ", referenciaId=" + this.referenciaId + ")";
    }
}