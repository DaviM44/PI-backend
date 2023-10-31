package com.example.projetointegrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetointegrador.dtos.AdminRequest;
import com.example.projetointegrador.dtos.AdminResponse;
import com.example.projetointegrador.entities.Admin;
import com.example.projetointegrador.mappers.AdminMapper;
import com.example.projetointegrador.repositories.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    public List<Admin> getAdmin(){
        return this.repository.findAll();
     }
    
    public AdminResponse save(AdminRequest admin) {
        var entity =  this.repository.save(AdminMapper.toEntity(admin));
        return AdminMapper.toDTO(entity);
       }
}
