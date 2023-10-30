package com.example.projetointegrador.dtos;

public record ProfessorResponse(
    Long id,
    String nome,
    String email,
    String telefone,
    String genero
) {
    
}
