package com.upc.agrofuturobackend.controllers;

import com.upc.agrofuturobackend.dtos.EmpresaDTO;
import com.upc.agrofuturobackend.entities.Empresa;
import com.upc.agrofuturobackend.entities.Users;
import com.upc.agrofuturobackend.serviceinterfaces.EmpresaService;
import com.upc.agrofuturobackend.serviceinterfaces.UserService;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<EmpresaDTO> listar() {
        return empresaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EmpresaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody EmpresaDTO empresaDTO) {
        ModelMapper m = new ModelMapper();
        Empresa empresa = m.map(empresaDTO, Empresa.class);
        empresaService.insert(empresa);
    }

    // After
    @PostMapping("/register-from-user/{userId}")
    public void registerFromUser(@PathVariable("userId") int userId, @RequestBody Empresa empresa) {
        Users user = userService.listId(userId);
        empresa.setUser(user);
        empresaService.insert(empresa);
    }

    @PutMapping
    public void modificar(@RequestBody EmpresaDTO empresaDTO) {
        ModelMapper m = new ModelMapper();
        Empresa empresa = m.map(empresaDTO, Empresa.class);
        empresaService.update(empresa);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        empresaService.delete(id);
    }

    @GetMapping("/{id}")
    public EmpresaDTO buscarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        return m.map(empresaService.listId(id), EmpresaDTO.class);
    }

    @GetMapping("/reporte2/{empresaId}")
    public List<Tuple> contarAgricultoresPorEmpresa(@PathVariable("empresaId") int empresaId) {
        return empresaService.contarAgricultoresPorEmpresa(empresaId);
    }


}
