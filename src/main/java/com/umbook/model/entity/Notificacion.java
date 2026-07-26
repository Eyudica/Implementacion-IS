package com.umbook.model.entity;

import com.umbook.model.enums.TipoNotificacion;
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
        name = "notificaciones"
)
public class Notificacion {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne(
            optional = false
    )
    @JoinColumn(
            name = "destinatario_id"
    )
    private Usuario destinatario;
    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipo;
    public boolean leida;
    public LocalDateTime fechaCreacion;
    private Long referenciaId;

    public void marcarComoLeida() {
        this.leida = true;
    }

    public void enviarEmail() {
    }

    private static boolean leida() {
        return false;
    }

    private static LocalDateTime fechaCreacion() {
        return LocalDateTime.now();
    }

    public static NotificacionBuilder builder() {
        return new NotificacionBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Usuario getDestinatario() {
        return this.destinatario;
    }

    public TipoNotificacion getTipo() {
        return this.tipo;
    }

    public boolean isLeida() {
        return this.leida;
    }

    public LocalDateTime getFechaCreacion() {
        return this.fechaCreacion;
    }

    public Long getReferenciaId() {
        return this.referenciaId;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setDestinatario(final Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public void setTipo(final TipoNotificacion tipo) {
        this.tipo = tipo;
    }

    public void setLeida(final boolean leida) {
        this.leida = leida;
    }

    public void setFechaCreacion(final LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setReferenciaId(final Long referenciaId) {
        this.referenciaId = referenciaId;
    }

    public Notificacion() {
        this.leida = leida();
        this.fechaCreacion = fechaCreacion();
    }

    public Notificacion(final Long id, final Usuario destinatario, final TipoNotificacion tipo, final boolean leida, final LocalDateTime fechaCreacion, final Long referenciaId) {
        this.id = id;
        this.destinatario = destinatario;
        this.tipo = tipo;
        this.leida = leida;
        this.fechaCreacion = fechaCreacion;
        this.referenciaId = referenciaId;
    }
}