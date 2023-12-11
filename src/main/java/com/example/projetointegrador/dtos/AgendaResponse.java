package com.example.projetointegrador.dtos;

public record AgendaResponse(
    long id,
    String dia,
    String semestre,
    String ano,
    String curso,
    String professor,
    String sala,
    String disciplina,
    String horario,
    String periodo,
    String lab
) {
    
}
