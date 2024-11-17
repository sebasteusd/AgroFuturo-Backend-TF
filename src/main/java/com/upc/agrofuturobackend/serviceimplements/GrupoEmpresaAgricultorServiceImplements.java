package com.upc.agrofuturobackend.serviceimplements;

import com.upc.agrofuturobackend.entities.GrupoEmpresaAgricultor;
import com.upc.agrofuturobackend.repositories.GrupoEmpresaAgricultorRepository;
import com.upc.agrofuturobackend.serviceinterfaces.GrupoEmpresaAgricultorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GrupoEmpresaAgricultorServiceImplements implements GrupoEmpresaAgricultorService {
    @Autowired
    private GrupoEmpresaAgricultorRepository grupoEmpresaAgricultorRepository;

    @Override
    public List<GrupoEmpresaAgricultor> list() { return grupoEmpresaAgricultorRepository.findAll();}

    @Override
    public void insert(GrupoEmpresaAgricultor grupoEmpresaAgricultor) { grupoEmpresaAgricultorRepository.save(grupoEmpresaAgricultor);}

    @Override
    public void update(GrupoEmpresaAgricultor grupoEmpresaAgricultor) { grupoEmpresaAgricultorRepository.save(grupoEmpresaAgricultor);}

    @Override
    public void delete(int grupoEmpresaAgricultorId) { grupoEmpresaAgricultorRepository.deleteById(grupoEmpresaAgricultorId);}

    @Override
    public GrupoEmpresaAgricultor listId(int id) { return grupoEmpresaAgricultorRepository.findById(id).orElse(new GrupoEmpresaAgricultor());}

}
