package com.example.projeto.biblioteca.model;

import com.example.projeto.biblioteca.dto.livro.LivroRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Autor autor;
    @Column(name = "ano_lancameto")
    private Integer anoLancamento;
    private String genero;
    private String isbn;
    private String sinopse;
    @Column(name = "ano_cadastro")
    private LocalDateTime dataCadastro;

    public Livro(Integer id){this.id = id;}

    public static Livro converter(LivroRequest livroRequest){
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
