package com.upc.agrofuturobackend.serviceimplements;

import com.upc.agrofuturobackend.entities.Empresa;
import com.upc.agrofuturobackend.entities.Users;
import com.upc.agrofuturobackend.repositories.EmpresaRepository;
import com.upc.agrofuturobackend.serviceinterfaces.EmpresaService;
import com.upc.agrofuturobackend.serviceinterfaces.UserService;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImplements implements EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Empresa> list() {
        return empresaRepository.findAll();
    }

    @Override
    public void insert(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    @Override
    public void update(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    @Override
    public void delete(int idempresa) {
        empresaRepository.deleteById(idempresa);
    }

    @Override
    public Empresa listId(int id) {
        return empresaRepository.findById(id).orElse(new Empresa());
    }

    @Override
    public List<Tuple> contarAgricultoresPorEmpresa(int empresaId) {
        return empresaRepository.contarAgricultoresPorEmpresa(empresaId);
    }

    @Override
    public void registerFromUser(int userId, Empresa empresa) {
        Users user = userService.listId(userId);
        empresa.setUser(user);
        empresaRepository.save(empresa);
    }
}
