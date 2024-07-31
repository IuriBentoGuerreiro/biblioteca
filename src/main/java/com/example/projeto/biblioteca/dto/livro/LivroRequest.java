package com.example.projeto.biblioteca.dto.livro;

import lombok.Data;

@Data
public class LivroRequest {

    private String titulo;
    private Integer autor;
    private Integer anoLancamento;
    private String genero;
    private String isbn;
    private String sinopse;
    private Integer quantidadeEstoque;
}
