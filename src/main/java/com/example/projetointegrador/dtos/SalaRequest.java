package com.example.projetointegrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record SalaRequest(
    @NotBlank(message = "O nome da sala não pode ser em branco")
    String nomedasala,
    @NotBlank(message = "A capacidade não pode ser em branco")
    String capacidade,
    @NotBlank(message = "A descrição não pode ser em branco")
    String descricao
) {
    
}
