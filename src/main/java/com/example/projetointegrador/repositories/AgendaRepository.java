package com.example.projetointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetointegrador.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{
    
}
