package com.example.projetointegrador.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetointegrador.dtos.DisciplinaRequest;
import com.example.projetointegrador.dtos.DisciplinaResponse;
import com.example.projetointegrador.entities.Disciplina;

public class DisciplinaMapper {
    public static Disciplina toEntity(DisciplinaRequest request) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(request.nome());
        disciplina.setCargahoraria(request.cargahoraria());
        return disciplina;
    }

    public static DisciplinaResponse toDTO(Disciplina disciplina) {
        return new DisciplinaResponse(disciplina.getId(), disciplina.getNome(),disciplina.getCargahoraria());
    }

    public static List<DisciplinaResponse> toDTOList(List<Disciplina> disciplina) {
        return disciplina.stream()
                .map(DisciplinaMapper::toDTO)
                .collect(Collectors.toList()); 
    }
}
