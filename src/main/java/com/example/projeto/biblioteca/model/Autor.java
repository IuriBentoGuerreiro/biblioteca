package com.example.projeto.biblioteca.model;

import com.example.projeto.biblioteca.dto.AutorRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "autor")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    public Autor (Integer id) {
        this.id = id;
    }

    public static Autor converterParaAutor(AutorRequest autorRequest){
        return Autor.builder()
                .nome(autorRequest.getNome())
                .dataNascimento(autorRequest.getDataNascimento())
                .dataCadastro(LocalDateTime.now())
                .build();
    }
}
