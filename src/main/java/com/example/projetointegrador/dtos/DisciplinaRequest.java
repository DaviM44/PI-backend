package com.example.projetointegrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record DisciplinaRequest(
    @NotBlank(message = "O nome não pode ser em branco")
    String nome,
    @NotBlank(message = "A carga horária não pode ser em branco")
    String cargahoraria
) {
    
}
