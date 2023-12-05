package com.example.projetointegrador.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetointegrador.dtos.LabRequest;
import com.example.projetointegrador.dtos.LabResponse;
import com.example.projetointegrador.entities.Lab;


public class LabMapper {

    public static Lab toEntity(LabRequest request) {
        Lab lab = new Lab();
        lab.setNomedolab(request.nomedolab());
        lab.setDescricao(request.descricao());
        lab.setCapacidade(request.capacidade());
        lab.setNdm(request.ndm());
        return lab;
    }

    public static LabResponse toDTO(Lab lab) {
        return new LabResponse(lab.getId(), lab.getNomedolab(),lab.getNdm(), lab.getCapacidade(),
                lab.getDescricao());
    }

    public static List<LabResponse> toDTOList(List<Lab> lab) {
        return lab.stream()
                .map(LabMapper::toDTO)
                .collect(Collectors.toList()); 
    }
}