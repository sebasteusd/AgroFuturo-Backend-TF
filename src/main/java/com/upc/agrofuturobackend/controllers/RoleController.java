package com.upc.agrofuturobackend.controllers;

import com.upc.agrofuturobackend.dtos.RoleDTO;
import com.upc.agrofuturobackend.entities.Role;
import com.upc.agrofuturobackend.serviceinterfaces.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleDTO> listar() {
        return roleService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RoleDTO roleDTO) {
        ModelMapper m = new ModelMapper();
        Role role = m.map(roleDTO, Role.class);
        roleService.insert(role);
    }

    @PutMapping
    public void modificar(@RequestBody RoleDTO roleDTO) {
        ModelMapper m = new ModelMapper();
        Role role = m.map(roleDTO, Role.class);
        roleService.update(role);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){
        roleService.delete(id);
    }

    @GetMapping("/{id}")
    public RoleDTO buscarId(@PathVariable("id") Long id){
        ModelMapper m = new ModelMapper();
        RoleDTO dto = m.map(roleService.listId(id), RoleDTO.class);
        return dto;
    }
}
