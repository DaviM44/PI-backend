package com.example.projetointegrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record AgendaRequest(
    @NotBlank(message = "O Dia não pode ser em branco")
    String dia,
    @NotBlank(message = "O Semestre não pode ser em branco")
    String semestre,
    @NotBlank(message = "O Ano não pode ser em branco")
    String ano,
    @NotBlank(message = "O curso não pode ser em branco")
    String curso,
    @NotBlank(message = "O Professor não pode ser em branco")
    String professor,
    @NotBlank(message = "A Sala não pode ser em branco")
    String sala,
    @NotBlank(message = "O lab não pode ser em branco")
    String lab,
    @NotBlank(message = "A Disciplina não pode ser em branco")
    String disciplina,
    @NotBlank(message = "O período não pode ser em branco")
    String periodo,
    @NotBlank(message = "O horário não pode ser em branco")
    String horario
    )
{
}
