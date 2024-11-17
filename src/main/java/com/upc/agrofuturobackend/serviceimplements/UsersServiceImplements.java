package com.upc.agrofuturobackend.serviceimplements;

import com.upc.agrofuturobackend.entities.Users;
import com.upc.agrofuturobackend.repositories.UsersRepository;
import com.upc.agrofuturobackend.serviceinterfaces.UserService;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsersServiceImplements implements UserService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> list() {
        return usersRepository.findAll();
    }

    @Override
    public void insert(Users users) {
        usersRepository.save(users);
    }

    @Override
    public Users listId(int id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public void update(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void delete(int IdUsuario) {
        usersRepository.deleteById(IdUsuario);
    }

    @Override
    public List<Tuple> usuariosConMasCompras(LocalDate from, LocalDate to) {
        return usersRepository.usuariosConMasCompras(from, to);
    }
}