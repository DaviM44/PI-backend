package com.example.projetointegrador.dtos;

public record LabResponse(
    Long id,
    String capacidade,
    String nomedolab,
    String descricao,
    String ndm
) {
    
}
