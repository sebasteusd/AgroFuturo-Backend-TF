package com.upc.agrofuturobackend.serviceinterfaces;

import com.upc.agrofuturobackend.entities.Empresa;
import jakarta.persistence.Tuple;

import java.util.List;

public interface EmpresaService {
    public List<Empresa> list();
    public void insert(Empresa empresa);
    public void update(Empresa empresa);
    public void delete(int empresaId);
    public Empresa listId(int id);
    public List<Tuple> contarAgricultoresPorEmpresa(int empresaId);
    public void registerFromUser(int userId, Empresa empresa);
}