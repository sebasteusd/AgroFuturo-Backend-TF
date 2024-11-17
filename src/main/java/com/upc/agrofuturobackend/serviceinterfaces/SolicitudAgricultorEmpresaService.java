package com.upc.agrofuturobackend.serviceinterfaces;

import com.upc.agrofuturobackend.entities.SolicitudAgricultorEmpresa;

import java.util.List;

public interface SolicitudAgricultorEmpresaService {
    public List<SolicitudAgricultorEmpresa> list();
    public void insert(SolicitudAgricultorEmpresa solicitudAgricultorEmpresa);
    public void update(SolicitudAgricultorEmpresa solicitudAgricultorEmpresa);
    public void delete(int idSolicitudAgricultorEmpresa);
    public SolicitudAgricultorEmpresa listId(int idSolicitudAgricultorEmpresa);
}
