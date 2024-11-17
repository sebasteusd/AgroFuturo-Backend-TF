package com.upc.agrofuturobackend.repositories;

import com.upc.agrofuturobackend.entities.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    @Query(value = "SELECT COUNT(*) FROM Notificaciones n WHERE n.id_usuario_destinatario = :usuarioId AND n.fecha_notificacion BETWEEN :from AND :to", nativeQuery = true)
    int contarNotificacionesParaUsuarioEnPeriodo(@Param("usuarioId") int usuarioId, @Param("from") LocalDate from, @Param("to") LocalDate to);
}
