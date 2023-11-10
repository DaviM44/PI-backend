package com.example.projetointegrador.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetointegrador.dtos.CursoRequest;
import com.example.projetointegrador.dtos.CursoResponse;
import com.example.projetointegrador.entities.Curso;

public class CursoMapper {
    public static Curso toEntity(CursoRequest request) {
        Curso curso = new Curso();
        curso.setNome(request.nome());
        curso.setPeriodo(request.periodo());
        curso.setDuracao(request.duracao());
        return curso;
    }

    public static CursoResponse toDTO(Curso curso) {
        return new CursoResponse(curso.getId(), curso.getNome(),curso.getPeriodo(), curso.getDuracao());
    }

    public static List<CursoResponse> toDTOList(List<Curso> curso) {
        return curso.stream()
                .map(CursoMapper::toDTO)
                .collect(Collectors.toList()); 
    }
}
