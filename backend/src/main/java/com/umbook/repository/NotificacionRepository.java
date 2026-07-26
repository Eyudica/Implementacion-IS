package com.umbook.repository;

import com.umbook.model.entity.Notificacion;
import com.umbook.model.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByDestinatarioAndLeida(Usuario destinatario, boolean leida);
}