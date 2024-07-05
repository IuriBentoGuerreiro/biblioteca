package com.example.projeto.biblioteca.controller;

import com.example.projeto.biblioteca.dto.LivroRequest;
import com.example.projeto.biblioteca.dto.LivroResponse;
import com.example.projeto.biblioteca.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Livro")
@RestController
@RequestMapping("biblioteca")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Operation(summary = "Salvar")
    @PostMapping
    public LivroResponse salvar (@RequestBody LivroRequest livroRequest){
        return livroService.salvar(livroRequest);
    }

    @Operation(summary = "Listar")
    @GetMapping
    public List<LivroResponse> listarTodos(){
        return livroService.buscarTodos();
    }

    @Operation(summary = "Pegar por id")
    @GetMapping("/{id}")
    public LivroResponse pegarPorId(@PathVariable Integer id){
        return LivroResponse.converter(livroService.pegarPorId(id));
    }

    @Operation(summary = "Atualizar")
    @PutMapping("/{id}")
    public LivroResponse atualizar(@PathVariable Integer id, @RequestBody LivroRequest livroRequest){
        return LivroResponse.converter(livroService.atualizar(id, livroRequest));
    }

    @Operation(summary = "Deletar")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        livroService.deletar(id);
    }
}
