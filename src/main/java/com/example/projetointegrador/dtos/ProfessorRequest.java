package com.example.projetointegrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record ProfessorRequest(
    @NotBlank(message = "O nome não pode ser em branco")
    String nome,
    @NotBlank(message = "O email não pode ser em branco")
    String email,
    @NotBlank(message = "O telefone não pode ser em branco")
    String telefone,
    @NotBlank(message = "o genêro não pode ser em branco")
    String genero
) {
 
}
