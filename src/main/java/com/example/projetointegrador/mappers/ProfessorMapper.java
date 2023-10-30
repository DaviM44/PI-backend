package com.example.projetointegrador.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetointegrador.dtos.ProfessorRequest;
import com.example.projetointegrador.dtos.ProfessorResponse;
import com.example.projetointegrador.entities.Professor;

public class ProfessorMapper {
    public static Professor toEntity(ProfessorRequest request) {
        Professor professor = new Professor();
        professor.setNome(request.nome());
        professor.setEmail(request.email());
        professor.setTelefone(request.telefone());
        professor.setGenero(request.genero());
        return professor;
    }

    public static ProfessorResponse toDTO(Professor professor) {
        return new ProfessorResponse(professor.getId(), professor.getNome(), professor.getEmail(), professor.getTelefone(),
                professor.getGenero());
    }

    public static List<ProfessorResponse> toDTOList(List<Professor> professor) {
        return professor.stream()
                .map(ProfessorMapper::toDTO)
                .collect(Collectors.toList()); 
    }
}
