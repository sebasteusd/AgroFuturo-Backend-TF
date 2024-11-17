package com.upc.agrofuturobackend.repositories;

import com.upc.agrofuturobackend.entities.SolicitudAgricultorEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudAgricultorEmpresaRepository extends JpaRepository<SolicitudAgricultorEmpresa, Integer> {
}
