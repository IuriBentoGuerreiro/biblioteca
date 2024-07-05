package com.example.projeto.biblioteca.controller;

import com.example.projeto.biblioteca.dto.LivroRequest;
import com.example.projeto.biblioteca.dto.LivroResponse;
import com.example.projeto.biblioteca.model.Livro;
import com.example.projeto.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("biblioteca")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroResponse salvar (@RequestBody LivroRequest livroRequest){
        return livroService.salvar(livroRequest);
    }

    @GetMapping
    public List<Livro> listarTodos(){
        return livroService.buscarTodos();
    }
}
