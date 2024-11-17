package com.upc.agrofuturobackend.serviceimplements;

import com.upc.agrofuturobackend.entities.Producto;
import com.upc.agrofuturobackend.repositories.ProductoRepository;
import com.upc.agrofuturobackend.serviceinterfaces.ProductoService;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplements implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> list() {
        return productoRepository.findAll();
    }

    @Override
    public void insert(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void update(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void delete(int idProducto) {
        productoRepository.deleteById(idProducto);
    }

    @Override
    public Producto listId(int id) {
        return productoRepository.findById(id).orElse(new Producto());
    }

    @Override
    public List<Tuple> listarProductosPorAgricultor(int agricultorId) {
        return productoRepository.listarProductosPorAgricultor(agricultorId);
    }
}
