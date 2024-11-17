package com.upc.agrofuturobackend.controllers;

import com.upc.agrofuturobackend.dtos.GrupoEmpresaAgricultorDTO;
import com.upc.agrofuturobackend.entities.GrupoEmpresaAgricultor;
import com.upc.agrofuturobackend.serviceinterfaces.GrupoEmpresaAgricultorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grupoEmpresaAgricultores")
public class GrupoEmpresaAgricultorController {
    @Autowired
    private GrupoEmpresaAgricultorService grupoEmpresaAgricultorService;

    @GetMapping
    public List<GrupoEmpresaAgricultorDTO> listar(){
        return grupoEmpresaAgricultorService.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, GrupoEmpresaAgricultorDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody GrupoEmpresaAgricultorDTO grupoEmpresaAgricultorDTO) {
        ModelMapper m = new ModelMapper();
        GrupoEmpresaAgricultor grupoEmpresaAgricultor = m.map(grupoEmpresaAgricultorDTO, GrupoEmpresaAgricultor.class);
        grupoEmpresaAgricultorService.insert(grupoEmpresaAgricultor);
    }
    @PutMapping
    public void modificar(@RequestBody GrupoEmpresaAgricultorDTO grupoEmpresaAgricultorDTO) {
        ModelMapper m = new ModelMapper();
        GrupoEmpresaAgricultor grupoEmpresaAgricultor = m.map(grupoEmpresaAgricultorDTO, GrupoEmpresaAgricultor.class);
        grupoEmpresaAgricultorService.update(grupoEmpresaAgricultor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        grupoEmpresaAgricultorService.delete(id);
    }

    @GetMapping("/{id}")
    public GrupoEmpresaAgricultorDTO buscarporid(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        GrupoEmpresaAgricultorDTO dto = m.map(grupoEmpresaAgricultorService.listId(id), GrupoEmpresaAgricultorDTO.class);
        return dto;
    }
}
