package com.upc.agrofuturobackend.serviceimplements;

import com.upc.agrofuturobackend.entities.Agricultor;
import com.upc.agrofuturobackend.entities.Users;
import com.upc.agrofuturobackend.serviceinterfaces.AgricultorService;
import com.upc.agrofuturobackend.serviceinterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.upc.agrofuturobackend.repositories.AgricultorRepository;

import java.util.List;

@Service
public class AgricultorServiceImplements implements AgricultorService {
    @Autowired
    private AgricultorRepository agricultorRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Agricultor> list() {
        return agricultorRepository.findAll();
    }

    @Override
    public void insert(Agricultor agricultor) {
        agricultorRepository.save(agricultor);
    }

    @Override
    public void update(Agricultor agricultor) {
        agricultorRepository.save(agricultor);
    }

    @Override
    public void delete(int agricultorId) {
        agricultorRepository.deleteById(agricultorId);
    }

    @Override
    public Agricultor listId(int id) {
        return agricultorRepository.findById(id).orElse(new Agricultor());
    }

    @Override
    public void registerFromUser(int userId, Agricultor agricultor) {
        Users user = userService.listId(userId);
        agricultor.setUser(user);
        agricultorRepository.save(agricultor);
    }
}
