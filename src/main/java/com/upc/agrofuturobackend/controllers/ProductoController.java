package com.upc.agrofuturobackend.controllers;

import com.upc.agrofuturobackend.dtos.ProductoDTO;
import com.upc.agrofuturobackend.entities.Producto;
import com.upc.agrofuturobackend.serviceinterfaces.ProductoService;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> listar() {
        return productoService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ProductoDTO productoDTO) {
        ModelMapper m = new ModelMapper();
        Producto producto = m.map(productoDTO, Producto.class);
        productoService.insert(producto);
    }
    @PutMapping
    public void modificar(@RequestBody ProductoDTO productoDTO) {
        ModelMapper m = new ModelMapper();
        Producto producto = m.map(productoDTO, Producto.class);
        productoService.update(producto);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        productoService.delete(id);
    }

    @GetMapping("/{id}")
    public ProductoDTO buscarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        return m.map(productoService.listId(id), ProductoDTO.class);
    }

    @GetMapping("/reporte3/{agricultorId}")
    public List<Tuple> listarProductosPorAgricultor(@PathVariable("agricultorId") int agricultorId) {
        return productoService.listarProductosPorAgricultor(agricultorId);
    }
}
