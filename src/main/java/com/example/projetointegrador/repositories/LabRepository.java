package com.example.projetointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetointegrador.entities.Lab;

public interface LabRepository extends JpaRepository<Lab, Long>  {
    
}
