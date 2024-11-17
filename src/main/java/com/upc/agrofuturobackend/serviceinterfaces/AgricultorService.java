package com.upc.agrofuturobackend.serviceinterfaces;

import com.upc.agrofuturobackend.entities.Agricultor;

import java.util.List;

public interface AgricultorService {
    public List<Agricultor> list();
    public void insert(Agricultor agricultor);
    public void update(Agricultor agricultor);
    public void delete(int agricultorId);
    public Agricultor listId(int id);
    public void registerFromUser(int userId, Agricultor agricultor);
}
