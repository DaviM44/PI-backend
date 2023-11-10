package com.example.projetointegrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record CursoRequest(
    @NotBlank(message = "O nome não pode ser em branco")
    String nome,
    @NotBlank(message = "O período não pode ser em branco")
    String periodo,
    @NotBlank(message = "A duração não pode ser em branco")
    String duracao
) {
    
}
