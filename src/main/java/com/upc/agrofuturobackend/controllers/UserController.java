package com.upc.agrofuturobackend.controllers;


import com.upc.agrofuturobackend.dtos.UsersDTO;
import com.upc.agrofuturobackend.entities.Users;
import com.upc.agrofuturobackend.serviceinterfaces.UserService;
import jakarta.persistence.Tuple;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UsersDTO> listar() {
        return userService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsersDTO usersDTO) {
        ModelMapper m = new ModelMapper();
        Users users = m.map(usersDTO, Users.class);
        userService.insert(users);
    }

    @PutMapping
    public void modificar(@RequestBody UsersDTO usersDTO) {
        ModelMapper m = new ModelMapper();
        Users users = m.map(usersDTO, Users.class);
        userService.update(users);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        userService.delete(id);
    }

    @GetMapping("/{id}")
    public UsersDTO listarId(@PathVariable("id") int id) {
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(userService.listId(id), UsersDTO.class);
        return dto;
    }
    @GetMapping("/reporte6")
    public List<Tuple> usuariosConMasCompras(@RequestParam("from") LocalDate from, @RequestParam("to") LocalDate to) {
        return userService.usuariosConMasCompras(from, to);
    }
}