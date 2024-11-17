package com.upc.agrofuturobackend.serviceimplements;

import com.upc.agrofuturobackend.entities.Role;
import com.upc.agrofuturobackend.repositories.RoleRepository;
import com.upc.agrofuturobackend.serviceinterfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplements implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @Override
    public void insert(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role listId(Long idRole) {
        return roleRepository.findById(idRole).orElse(new Role());
    }

    @Override
    public void update(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Long idRole) {
        roleRepository.deleteById(idRole);
    }

    @Override
    public List<String[]> countrol() {
        return roleRepository.countrol();
    }
}
