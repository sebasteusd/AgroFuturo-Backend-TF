package com.upc.agrofuturobackend.serviceinterfaces;

import com.upc.agrofuturobackend.entities.Notificacion;

import java.time.LocalDate;
import java.util.List;

public interface NotificacionService {
    public List<Notificacion> list();
    public void insert(Notificacion notificacion);
    public void update(Notificacion notificacion);
    public void delete(int notificacionId);
    public Notificacion listId(int id);
    public int contarNotificacionesParaUsuarioEnPeriodo(int usuarioId, LocalDate from, LocalDate to);
}
