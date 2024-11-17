package com.upc.agrofuturobackend.repositories;

import com.upc.agrofuturobackend.entities.Producto;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query(value = "SELECT p.nombre_producto FROM Productos p WHERE p.id_agricultor = :agricultorId", nativeQuery = true)
    List<Tuple> listarProductosPorAgricultor(@Param("agricultorId") int agricultorId);
}
