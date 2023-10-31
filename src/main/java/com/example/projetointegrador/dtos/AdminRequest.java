package com.example.projetointegrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record AdminRequest(
    @NotBlank(message = "A senha não pode ser em branco")
    String senha,
    @NotBlank(message = "O email não pode ser em branco")
    String email
) {
    
}
