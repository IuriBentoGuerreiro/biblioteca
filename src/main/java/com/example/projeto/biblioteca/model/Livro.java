package com.example.projeto.biblioteca.model;

import com.example.projeto.biblioteca.dto.LivroRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "livro")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "fk_autor")
    private Autor autor;
    @Column(name = "ano_lancameto")
    private Integer anoLancamento;
    private String genero;
    private String isbn;
    private String sinopse;
    @Column(name = "ano_cadastro")
    private LocalDateTime dataCadastro;

    public static Livro converterParaLivro(LivroRequest livroRequest){
        return Livro.builder()
                .titulo(livroRequest.getTitulo())
                .autor(new Autor(livroRequest.getAutor()))
                .anoLancamento(livroRequest.getAnoLancamento())
                .genero(livroRequest.getGenero())
                .isbn(livroRequest.getIsbn())
                .sinopse(livroRequest.getSinopse())
                .dataCadastro(LocalDateTime.now())
                .build();
    }
}
