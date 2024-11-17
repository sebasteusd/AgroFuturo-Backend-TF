package com.upc.agrofuturobackend.controllers;

import com.upc.agrofuturobackend.dtos.AgricultorDTO;
import com.upc.agrofuturobackend.entities.Agricultor;
import com.upc.agrofuturobackend.entities.Users;
import com.upc.agrofuturobackend.serviceinterfaces.AgricultorService;
import com.upc.agrofuturobackend.serviceinterfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agricultores")
public class AgricultorController {
    @Autowired
    private AgricultorService agricultorService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<AgricultorDTO> listar() {
        return agricultorService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AgricultorDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody AgricultorDTO agricultorDTO) {
        ModelMapper m = new ModelMapper();
        Agricultor agricultor = m.map(agricultorDTO, Agricultor.class);
        agricultorService.insert(agricultor);
    }

    @PostMapping("/register-from-user/{userId}")
    public void registerFromUser(@PathVariable("userId") int userId, @RequestBody Agricultor agricultor) {
        Users user = userService.listId(userId);
        agricultor.setUser(user);
        agricultorService.insert(agricultor);
    }

    @PutMapping
    public void modificar(@RequestBody AgricultorDTO agricultorDTO) {
        ModelMapper m = new ModelMapper();
        Agricultor agricultor = m.map(agricultorDTO, Agricultor.class);
        agricultorService.update(agricultor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        agricultorService.delete(id);
    }

    @GetMapping("/{id}")
    public AgricultorDTO buscarporid(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        AgricultorDTO dto = m.map(agricultorService.listId(id), AgricultorDTO.class);
        return dto;
    }
}

