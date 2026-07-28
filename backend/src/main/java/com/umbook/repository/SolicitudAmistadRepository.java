package com.umbook.repository;

import com.umbook.model.entity.SolicitudAmistad;
import com.umbook.model.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudAmistadRepository extends JpaRepository<SolicitudAmistad, Long> {
    Optional<SolicitudAmistad> findByRemitenteAndDestinatario(Usuario remitente, Usuario destinatario);
    
    @org.springframework.data.jpa.repository.Query("SELECT s FROM SolicitudAmistad s WHERE " +
        "((s.remitente = :u1 AND s.destinatario = :u2) OR (s.remitente = :u2 AND s.destinatario = :u1)) " +
        "AND s.estado = :estado")
    java.util.List<SolicitudAmistad> findByUsuariosAndEstado(
        @org.springframework.data.repository.query.Param("u1") Usuario u1, 
        @org.springframework.data.repository.query.Param("u2") Usuario u2, 
        @org.springframework.data.repository.query.Param("estado") com.umbook.model.enums.EstadoSolicitud estado
    );
}