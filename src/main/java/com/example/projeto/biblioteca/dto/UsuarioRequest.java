package com.example.projeto.biblioteca.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRequest {

    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
}
