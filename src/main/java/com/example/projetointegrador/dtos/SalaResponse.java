package com.example.projetointegrador.dtos;

public record SalaResponse(
    Long id,
    String tipo,
    String capacidade,
    String ndm,
    String nomedasala,
    String descricao
) {
    
}
