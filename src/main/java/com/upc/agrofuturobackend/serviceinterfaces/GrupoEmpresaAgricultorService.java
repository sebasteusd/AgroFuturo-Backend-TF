package com.upc.agrofuturobackend.serviceinterfaces;

import com.upc.agrofuturobackend.entities.GrupoEmpresaAgricultor;

import java.util.List;

public interface GrupoEmpresaAgricultorService {
    public List<GrupoEmpresaAgricultor> list();
    public void insert(GrupoEmpresaAgricultor grupoEmpresaAgricultor);
    public void update(GrupoEmpresaAgricultor grupoEmpresaAgricultor);
    public void delete(int grupoempresaagricultorId);
    public GrupoEmpresaAgricultor listId(int id);
}
