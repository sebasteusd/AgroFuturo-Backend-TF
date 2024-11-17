package com.upc.agrofuturobackend.repositories;

import com.upc.agrofuturobackend.entities.Users;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);

    //reporte 6
    @Query(value = "SELECT u.nombre_usuario, COUNT(c.id_compra) AS total_compras JOIN Compras c ON u.id_usuario = c.id_usuario WHERE c.fecha_compra BETWEEN :from AND :to GROUP BY u.id_usuario, u.nombre_usuario ORDER BY total_compras DESC LIMIT 5", nativeQuery = true)
    List<Tuple> usuariosConMasCompras(@Param("from") LocalDate from, @Param("to") LocalDate to);

    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

}
