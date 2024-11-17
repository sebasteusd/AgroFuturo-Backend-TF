package com.upc.agrofuturobackend.repositories;

import com.upc.agrofuturobackend.entities.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgricultorRepository extends JpaRepository<Agricultor, Integer> {
}
