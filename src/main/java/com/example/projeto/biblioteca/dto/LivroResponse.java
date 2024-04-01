package com.example.projeto.biblioteca.dto;

import com.example.projeto.biblioteca.model.Autor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class LivroResponse {

    private Integer id;
    private String titulo;
    private Autor autor;
    private Integer anoLancamento;
    private String genero;
    private String isbn;
    private String sinopse;
    private LocalDateTime dataCadastro;
}
