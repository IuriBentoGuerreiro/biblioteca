package com.example.projeto.biblioteca.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AutorRequest {

    private String nome;
    private LocalDate dataNascimento;
}
