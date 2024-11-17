package com.upc.agrofuturobackend.serviceinterfaces;

import com.upc.agrofuturobackend.entities.Compra;

import java.time.LocalDate;
import java.util.List;

public interface CompraService {
    public List<Compra> list();
    public void insert(Compra compra);
    public void update(Compra compra);
    public void delete(int compraId);
    public Compra listId(int id);
    public double totalComprasPorUsuarioEnPeriodo(int userId, LocalDate from, LocalDate to);
}
