package com.upc.agrofuturobackend.serviceimplements;

import com.upc.agrofuturobackend.entities.Notificacion;
import com.upc.agrofuturobackend.repositories.NotificacionRepository;
import com.upc.agrofuturobackend.serviceinterfaces.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificacionServiceImplements implements NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    @Override
    public List<Notificacion> list() {
        return notificacionRepository.findAll();
    }

    @Override
    public void insert(Notificacion notificacion) {
        notificacionRepository.save(notificacion);
    }

    @Override
    public void update(Notificacion notificacion) {
        notificacionRepository.save(notificacion);
    }

    @Override
    public void delete(int notificacionId) {
        notificacionRepository.deleteById(notificacionId);
    }

    @Override
    public Notificacion listId(int id) {
        return notificacionRepository.findById(id).orElse(new Notificacion());
    }

    @Override
    public int contarNotificacionesParaUsuarioEnPeriodo(int usuarioId, LocalDate from, LocalDate to) {
        return notificacionRepository.contarNotificacionesParaUsuarioEnPeriodo(usuarioId, from, to);
    }
}
