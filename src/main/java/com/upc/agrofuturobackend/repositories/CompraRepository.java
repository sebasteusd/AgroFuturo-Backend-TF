package com.upc.agrofuturobackend.repositories;

import com.upc.agrofuturobackend.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
    @Query(value = "SELECT SUM(c.total) as compra_total FROM Compras c WHERE c.id_usuario = :userId AND c.fecha_compra BETWEEN :from AND :to", nativeQuery = true)
    double totalComprasPorUsuarioEnPeriodo(@Param("userId") int userId, @Param("from") LocalDate from, @Param("to") LocalDate to);
}
