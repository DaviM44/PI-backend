package com.example.projetointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetointegrador.entities.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    
}
