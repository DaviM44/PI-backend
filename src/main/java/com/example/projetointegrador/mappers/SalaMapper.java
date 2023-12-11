package com.example.projetointegrador.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetointegrador.dtos.SalaRequest;
import com.example.projetointegrador.dtos.SalaResponse;
import com.example.projetointegrador.entities.Sala;

public class SalaMapper {
    public static Sala toEntity(SalaRequest request) {
        Sala sala = new Sala();
        sala.setCapacidade(request.capacidade());
        sala.setDescricao(request.descricao());
        sala.setNomedasala(request.nomedasala());
        return sala;
    }

    public static SalaResponse toDTO(Sala sala) {
        return new SalaResponse(sala.getId(), sala.getNomedasala(), sala.getCapacidade(),
                sala.getDescricao());
    }

    public static List<SalaResponse> toDTOList(List<Sala> sala) {
        return sala.stream()
                .map(SalaMapper::toDTO)
                .collect(Collectors.toList()); 
    }
}