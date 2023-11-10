package com.example.projetointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetointegrador.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
