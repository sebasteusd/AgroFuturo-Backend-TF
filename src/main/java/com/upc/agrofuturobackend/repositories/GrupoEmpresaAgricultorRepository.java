package com.upc.agrofuturobackend.repositories;

import com.upc.agrofuturobackend.entities.GrupoEmpresaAgricultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoEmpresaAgricultorRepository extends JpaRepository<GrupoEmpresaAgricultor, Integer> {
}
