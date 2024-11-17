package com.upc.agrofuturobackend.serviceimplements;

import com.upc.agrofuturobackend.entities.GrupoAgricultor;
import com.upc.agrofuturobackend.repositories.GrupoAgricultorRepository;
import com.upc.agrofuturobackend.serviceinterfaces.GrupoAgricultorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoAgricultorServiceImplements implements GrupoAgricultorService {
    @Autowired
    private GrupoAgricultorRepository grupoAgricultorRepository;

    @Override
    public List<GrupoAgricultor> list() {
        return  grupoAgricultorRepository.findAll();
    }

    @Override
    public void insert(GrupoAgricultor grupoAgricultor) {
        grupoAgricultorRepository.save(grupoAgricultor);
    }

    @Override
    public void update(GrupoAgricultor grupoAgricultor) {
        grupoAgricultorRepository.save(grupoAgricultor);
    }

    @Override
    public void delete(int idgrupo) {
        grupoAgricultorRepository.deleteById(idgrupo);
    }

    @Override
    public GrupoAgricultor listId(int id) {
        return grupoAgricultorRepository.findById(id).orElse(new GrupoAgricultor());
    }
}
