package com.example.projetointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetointegrador.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    
}
