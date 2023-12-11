package com.example.projetointegrador.dtos;

public record LabResponse(
    Long id,
    String nomedolab,
    String capacidade,
    String descricao,
    String ndm
) {
    
}
