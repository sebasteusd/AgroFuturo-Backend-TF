package com.upc.agrofuturobackend.repositories;

import com.upc.agrofuturobackend.entities.Empresa;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    @Query(value = "SELECT e.nombre as Empresa, COUNT(*) as Agricultores FROM Tabla_de_Grupos_de_Empresas_con_Agricultores g JOIN Empresa e ON g.id_empresa = e.id WHERE g.id_empresa = :empresaId GROUP BY e.nombre", nativeQuery = true)
    List<Tuple> contarAgricultoresPorEmpresa(@Param("empresaId") int empresaId);
}
