package com.upc.agrofuturobackend.serviceimplements;

import com.upc.agrofuturobackend.entities.SolicitudAgricultorEmpresa;
import com.upc.agrofuturobackend.repositories.SolicitudAgricultorEmpresaRepository;
import com.upc.agrofuturobackend.serviceinterfaces.SolicitudAgricultorEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudAgricultorEmpresaServiceImplements implements SolicitudAgricultorEmpresaService {
    @Autowired
    private SolicitudAgricultorEmpresaRepository solicitudAgricultorEmpresaRepository;

    @Override
    public List<SolicitudAgricultorEmpresa> list() {
        return solicitudAgricultorEmpresaRepository.findAll();
    }

    @Override
    public void insert(SolicitudAgricultorEmpresa solicitudAgricultorEmpresa) {
        solicitudAgricultorEmpresaRepository.save(solicitudAgricultorEmpresa);
    }

    @Override
    public void update(SolicitudAgricultorEmpresa solicitudAgricultorEmpresa) {
        solicitudAgricultorEmpresaRepository.save(solicitudAgricultorEmpresa);
    }

    @Override
    public void delete(int idsolicitudAgricultorEmpresa) {
        solicitudAgricultorEmpresaRepository.deleteById(idsolicitudAgricultorEmpresa);
    }

    @Override
    public SolicitudAgricultorEmpresa listId(int id) {
        return solicitudAgricultorEmpresaRepository.findById(id).orElse(new SolicitudAgricultorEmpresa());
    }
}
