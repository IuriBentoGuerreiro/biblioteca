package com.example.projeto.biblioteca.dto.autor;

import com.example.projeto.biblioteca.model.Autor;
import com.example.projeto.biblioteca.model.Livro;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AutorResponse {

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private LocalDateTime dataCadastro;
    private List<Livro> livros;

    public static AutorResponse converter(Autor autor) {
        var response = new AutorResponse();
        BeanUtils.copyProperties(autor, response);
        return response;
    }
}
