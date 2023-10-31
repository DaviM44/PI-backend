package com.example.projetointegrador.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetointegrador.dtos.AdminRequest;
import com.example.projetointegrador.dtos.AdminResponse;
import com.example.projetointegrador.entities.Admin;

public class AdminMapper {
    public static Admin toEntity(AdminRequest request) {
        Admin admin = new Admin();
        admin.setSenha(request.senha());
        admin.setEmail(request.email());
        return admin;
    }

    public static AdminResponse toDTO(Admin admin) {
        return new AdminResponse(admin.getId(), admin.getSenha(), admin.getEmail());
    }

    public static List<AdminResponse> toDTOList(List<Admin> admin) {
        return admin.stream()
                .map(AdminMapper::toDTO)
                .collect(Collectors.toList()); 
    }
}
