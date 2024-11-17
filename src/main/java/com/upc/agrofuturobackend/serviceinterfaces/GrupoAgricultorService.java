package com.upc.agrofuturobackend.serviceinterfaces;

import com.upc.agrofuturobackend.entities.GrupoAgricultor;

import java.util.List;

public interface GrupoAgricultorService {
    public List<GrupoAgricultor> list();
    public void insert(GrupoAgricultor grupoAgricultor);
    public void update(GrupoAgricultor grupoAgricultor);
    public void delete(int idgrupo);
    public GrupoAgricultor listId(int id);
}
