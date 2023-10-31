package com.example.projetointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetointegrador.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>  {
    
}
