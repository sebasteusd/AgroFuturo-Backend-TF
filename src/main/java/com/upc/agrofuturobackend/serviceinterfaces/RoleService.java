package com.upc.agrofuturobackend.serviceinterfaces;

import com.upc.agrofuturobackend.entities.Role;

import java.util.List;

public interface RoleService {
    public List<Role> list();
    public void insert(Role role);
    public Role listId(Long idRole);
    public void update(Role role);
    public void delete(Long idRole);
    public List<String[]> countrol();

}
