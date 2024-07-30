package com.example.projeto.biblioteca.controller;

import com.example.projeto.biblioteca.dto.autor.AutorRequest;
import com.example.projeto.biblioteca.dto.autor.AutorResponse;
import com.example.projeto.biblioteca.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Autor")
@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @Operation(summary = "Salvar")
    @PostMapping
    public AutorResponse salvar(@RequestBody AutorRequest autorRequest) {
        return autorService.salvar(autorRequest);
    }

    @Operation(summary = "Listar")
    @GetMapping
    public List<AutorResponse> listar(){
        return autorService.listar();
    }

    @Operation(summary = "Pegar por id")
    @GetMapping("/{id}")
    public AutorResponse pegarPorId(@PathVariable Integer id){
        return AutorResponse.converter(autorService.pegarPorId(id));
    }

    @Operation(summary = "Atualizar")
    @PutMapping("/{id}")
    public AutorResponse atualizar(@PathVariable Integer id, @RequestBody AutorRequest autorRequest){
        return AutorResponse.converter(autorService.atualizar(id, autorRequest));
    }

    @Operation(summary = "Deletar")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        autorService.deletar(id);
    }
}
