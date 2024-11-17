package com.upc.agrofuturobackend.controllers;

import com.upc.agrofuturobackend.dtos.CompraDTO;
import com.upc.agrofuturobackend.entities.Compra;
import com.upc.agrofuturobackend.serviceinterfaces.CompraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<CompraDTO> listar(){
        return compraService.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CompraDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CompraDTO compraDTO) {
        ModelMapper m = new ModelMapper();
        Compra compra = m.map(compraDTO, Compra.class);
        compraService.insert(compra);
    }

    @PutMapping
    public void modificar(@RequestBody CompraDTO compraDTO) {
        ModelMapper m = new ModelMapper();
        Compra compra = m.map(compraDTO, Compra.class);
        compraService.update(compra);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        compraService.delete(id);
    }

    @GetMapping("/{id}")
    public CompraDTO buscarporid(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        CompraDTO dto = m.map(compraService.listId(id), CompraDTO.class);
        return dto;
    }

    @GetMapping("/reporte1")
    public double totalComprasPorUsuarioEnPeriodo(@RequestParam int userId, @RequestParam String from, @RequestParam String to) {
        LocalDate fromDate = LocalDate.parse(from);
        LocalDate toDate = LocalDate.parse(to);
        return compraService.totalComprasPorUsuarioEnPeriodo(userId, fromDate, toDate);
    }
}
