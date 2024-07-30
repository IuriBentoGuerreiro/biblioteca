package com.example.projeto.biblioteca.dto.livro;

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
    private Integer anoLancamento;
    private String genero;
    private String isbn;
    private String sinopse;
    private LocalDateTime dataCadastro;
    private Autor autor;

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
