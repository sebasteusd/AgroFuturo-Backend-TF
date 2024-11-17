package com.upc.agrofuturobackend.controllers;

import com.upc.agrofuturobackend.dtos.SolicitudAgricultorEmpresaDTO;
import com.upc.agrofuturobackend.entities.SolicitudAgricultorEmpresa;
import com.upc.agrofuturobackend.serviceinterfaces.SolicitudAgricultorEmpresaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/solicitudagricultorempresas")
public class SolicitudAgricultorEmpresaController {
    @Autowired
    private SolicitudAgricultorEmpresaService solicitudAgricultorEmpresaService;

    @GetMapping
    public List<SolicitudAgricultorEmpresaDTO> listar() {
        return solicitudAgricultorEmpresaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SolicitudAgricultorEmpresaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody SolicitudAgricultorEmpresaDTO solicitudAgricultorEmpresaDTO) {
        ModelMapper m = new ModelMapper();
        SolicitudAgricultorEmpresa solicitudAgricultorEmpresa = m.map(solicitudAgricultorEmpresaDTO, SolicitudAgricultorEmpresa.class);
        solicitudAgricultorEmpresaService.insert(solicitudAgricultorEmpresa);
    }
    @PutMapping
    public void modificar(@RequestBody SolicitudAgricultorEmpresaDTO solicitudAgricultorEmpresaDTO) {
        ModelMapper m = new ModelMapper();
        SolicitudAgricultorEmpresa solicitudAgricultorEmpresa = m.map(solicitudAgricultorEmpresaDTO, SolicitudAgricultorEmpresa.class);
        solicitudAgricultorEmpresaService.update(solicitudAgricultorEmpresa);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        solicitudAgricultorEmpresaService.delete(id);
    }

    @GetMapping("/{id}")
    public SolicitudAgricultorEmpresaDTO buscarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        return m.map(solicitudAgricultorEmpresaService.listId(id), SolicitudAgricultorEmpresaDTO.class);
    }
}
