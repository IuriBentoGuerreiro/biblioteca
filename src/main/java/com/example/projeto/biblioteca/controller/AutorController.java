package com.example.projeto.biblioteca.controller;

import com.example.projeto.biblioteca.dto.AutorRequest;
import com.example.projeto.biblioteca.dto.AutorResponse;
import com.example.projeto.biblioteca.model.Autor;
import com.example.projeto.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutorResponse salvar(@RequestBody AutorRequest autorRequest) {
        return autorService.salvar(autorRequest);
    }

    @GetMapping
    public List<AutorResponse> listar(){
        return autorService.listar();
    }

    @GetMapping("/{id}")
    public AutorResponse pegarPorId(@PathVariable Integer id){
        return AutorResponse.converter(autorService.pegarPorId(id));
    }

    @PutMapping("/{id}")
    public AutorResponse atualizar(@PathVariable Integer id, @RequestBody AutorRequest autorRequest){
        return AutorResponse.converter(autorService.atualizar(id, autorRequest));
    }

    @DeleteMapping
    public void deletar(Integer id){
        autorService.deletar(id);
    }
}
