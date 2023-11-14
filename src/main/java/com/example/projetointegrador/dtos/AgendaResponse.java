package com.example.projetointegrador.dtos;

public record AgendaResponse(
    long id,
    String dia,
    String semestre,
    String ano,
    Integer curso,
    Integer professor,
    Integer sala,
    Integer disciplina,
    Integer horario,
    Integer periodo
) {
    
}
