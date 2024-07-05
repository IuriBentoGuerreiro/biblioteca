package com.example.projeto.biblioteca.controller;

import com.example.projeto.biblioteca.dto.LivroRequest;
import com.example.projeto.biblioteca.dto.LivroResponse;
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
    public List<LivroResponse> listarTodos(){
        return livroService.buscarTodos();
    }

    @GetMapping("/{id}")
    public LivroResponse pegarPorId(@PathVariable Integer id){
        return LivroResponse.converter(livroService.pegarPorId(id));
    }

    @PutMapping("/{id}")
    public LivroResponse atualizar(@PathVariable Integer id, @RequestBody LivroRequest livroRequest){
        return LivroResponse.converter(livroService.atualizar(id, livroRequest));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        livroService.deletar(id);
    }
}
