package com.upc.agrofuturobackend.serviceinterfaces;

import com.upc.agrofuturobackend.entities.Producto;
import jakarta.persistence.Tuple;

import java.util.List;

public interface ProductoService {
    public List<Producto> list();
    public void insert(Producto producto);
    public void update(Producto producto);
    public void delete(int idProducto);
    public Producto listId(int idProducto);
    public List<Tuple> listarProductosPorAgricultor(int agricultorId);
}
