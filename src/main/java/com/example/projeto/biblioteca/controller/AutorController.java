package com.example.projeto.biblioteca.controller;

import com.example.projeto.biblioteca.dto.AutorRequest;
import com.example.projeto.biblioteca.model.Autor;
import com.example.projeto.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autor salvar (@RequestBody AutorRequest autorRequest) {
        return autorService.salvar(autorRequest);
    }
}
