package com.upc.agrofuturobackend.controllers;

import com.upc.agrofuturobackend.dtos.AgricultorDTO;
import com.upc.agrofuturobackend.dtos.NotificacionDTO;
import com.upc.agrofuturobackend.entities.Agricultor;
import com.upc.agrofuturobackend.entities.Notificacion;
import com.upc.agrofuturobackend.serviceinterfaces.AgricultorService;
import com.upc.agrofuturobackend.serviceinterfaces.NotificacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public List<NotificacionDTO> listar(){
        return notificacionService.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody NotificacionDTO notificacionDTO) {
        ModelMapper m = new ModelMapper();
        Notificacion notificacion = m.map(notificacionDTO, Notificacion.class);
        notificacionService.insert(notificacion);
    }

    @PutMapping
    public void modificar(@RequestBody NotificacionDTO notificacionDTO) {
        ModelMapper m = new ModelMapper();
        Notificacion notificacion = m.map(notificacionDTO, Notificacion.class);
        notificacionService.update(notificacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){notificacionService.delete(id);}

    @GetMapping("/{id}")
    public NotificacionDTO buscarporid(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto = m.map(notificacionService.listId(id), NotificacionDTO.class);
        return dto;
    }

    @GetMapping("/reporte4")
    public int contarNotificacionesParaUsuarioEnPeriodo(@RequestParam("usuarioId") int usuarioId, @RequestParam("from") LocalDate from, @RequestParam("to") LocalDate to) {
        return notificacionService.contarNotificacionesParaUsuarioEnPeriodo(usuarioId, from, to);
    }
}
