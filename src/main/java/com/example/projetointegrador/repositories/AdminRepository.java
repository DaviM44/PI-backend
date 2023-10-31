package com.example.projetointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetointegrador.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
