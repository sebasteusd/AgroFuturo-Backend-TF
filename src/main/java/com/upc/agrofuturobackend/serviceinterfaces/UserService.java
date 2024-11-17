package com.upc.agrofuturobackend.serviceinterfaces;

import com.upc.agrofuturobackend.entities.Users;
import jakarta.persistence.Tuple;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    public List<Users> list();
    public void insert (Users users);
    public Users listId(int IdUsuario);
    public void update(Users users);
    public void delete(int IdUsuario);
    public List<Tuple> usuariosConMasCompras(LocalDate from, LocalDate to);
}
