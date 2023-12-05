package com.example.projetointegrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record LabRequest(
    @NotBlank(message = "O nome da sala não pode ser em branco")
    String nomedolab,
    @NotBlank(message = "A capacidade não pode ser em branco")
    String capacidade,
    @NotBlank(message = "A descrição não pode ser em branco")
    String descricao,
    @NotBlank(message = "A descrição não pode ser em branco")
    String ndm
) {
    
}
