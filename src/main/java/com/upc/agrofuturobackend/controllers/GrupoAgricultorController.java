package com.upc.agrofuturobackend.controllers;

import com.upc.agrofuturobackend.dtos.GrupoAgricultorDTO;
import com.upc.agrofuturobackend.entities.GrupoAgricultor;
import com.upc.agrofuturobackend.serviceinterfaces.GrupoAgricultorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grupoAgricultor")
public class GrupoAgricultorController {

    @Autowired
    private GrupoAgricultorService grupoAgricultorService;

    @GetMapping
    public List<GrupoAgricultorDTO> listar() {
        return grupoAgricultorService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, GrupoAgricultorDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody GrupoAgricultorDTO grupoAgricultorDTO) {
        ModelMapper m = new ModelMapper();
        GrupoAgricultor grupoAgricultor = m.map(grupoAgricultorDTO, GrupoAgricultor.class);
        grupoAgricultorService.insert(grupoAgricultor);
    }
    @PutMapping
    public void modificar(@RequestBody GrupoAgricultorDTO grupoAgricultorDTO) {
        ModelMapper m = new ModelMapper();
        GrupoAgricultor grupoAgricultor = m.map(grupoAgricultorDTO, GrupoAgricultor.class);
        grupoAgricultorService.update(grupoAgricultor);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        grupoAgricultorService.delete(id);
    }

    @GetMapping("/{id}")
    public GrupoAgricultorDTO buscarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        return m.map(grupoAgricultorService.listId(id), GrupoAgricultorDTO.class);
    }
}
