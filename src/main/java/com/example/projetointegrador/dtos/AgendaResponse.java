package com.example.projetointegrador.dtos;

public record AgendaResponse(
    long id,
    String dia,
    String semestre,
    String ano,
    Integer curso,
    String professor,
    Integer sala,
    Integer disciplina,
    String horario,
    String periodo
) {
    
}
