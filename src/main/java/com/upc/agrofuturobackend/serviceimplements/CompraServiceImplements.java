package com.upc.agrofuturobackend.serviceimplements;

import com.upc.agrofuturobackend.entities.Compra;
import com.upc.agrofuturobackend.repositories.CompraRepository;
import com.upc.agrofuturobackend.serviceinterfaces.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompraServiceImplements implements CompraService {
    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> list() {
        return compraRepository.findAll();
    }

    @Override
    public void insert(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public void update(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public void delete(int compraId) {
        compraRepository.deleteById(compraId);
    }

    @Override
    public Compra listId(int id) {
        return compraRepository.findById(id).orElse(new Compra());
    }

    @Override
    public double totalComprasPorUsuarioEnPeriodo(int userId, LocalDate from, LocalDate to) {
        return compraRepository.totalComprasPorUsuarioEnPeriodo(userId, from, to);
    }
}
