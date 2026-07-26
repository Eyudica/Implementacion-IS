package com.umbook.repository;

import com.umbook.model.entity.SolicitudAmistad;
import com.umbook.model.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudAmistadRepository extends JpaRepository<SolicitudAmistad, Long> {
    Optional<SolicitudAmistad> findByRemitenteAndDestinatario(Usuario remitente, Usuario destinatario);
}