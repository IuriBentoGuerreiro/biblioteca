package com.example.projeto.biblioteca.dto;

import com.example.projeto.biblioteca.model.Autor;
import com.example.projeto.biblioteca.model.Livro;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class LivroResponse {

    private Integer id;
    private String titulo;
    private Autor autor;
    private Integer anoLancamento;
    private String genero;
    private String isbn;
    private String sinopse;
    private LocalDateTime dataCadastro;

    public static LivroResponse converter(Livro livro){
        return LivroResponse.builder()
                .id(livro.getId())
                .titulo(livro.getTitulo())
                .autor(livro.getAutor())
                .anoLancamento(livro.getAnoLancamento())
                .genero(livro.getGenero())
                .isbn(livro.getIsbn())
                .sinopse(livro.getSinopse())
                .dataCadastro(LocalDateTime.now())
                .build();
    }
}
