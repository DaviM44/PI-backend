package com.example.projetointegrador.dtos;

public record AgendaResponse(
    long id,
    String dia,
    Integer curso,
    Integer professor,
    Integer sala,
    Integer disciplina,
    Integer horario,
    Integer periodo
) {
    
}
