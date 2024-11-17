package com.upc.agrofuturobackend.repositories;

import com.upc.agrofuturobackend.entities.GrupoAgricultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoAgricultorRepository extends JpaRepository<GrupoAgricultor, Integer> {
}
