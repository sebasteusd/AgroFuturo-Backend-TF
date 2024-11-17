package com.upc.agrofuturobackend.repositories;

import com.upc.agrofuturobackend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "SELECT r.rol, COUNT(r.user_id) AS Cantidad_Usuarios" +
            " FROM Roles  r GROUP BY r.rol", nativeQuery = true)
    public List<String[]> countrol();
}
