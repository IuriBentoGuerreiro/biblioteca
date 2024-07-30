package com.example.projeto.biblioteca.controller;

import com.example.projeto.biblioteca.dto.usuario.UsuarioRequest;
import com.example.projeto.biblioteca.dto.usuario.UsuarioResponse;
import com.example.projeto.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioResponse salvar(UsuarioRequest usuarioRequest){
        return usuarioService.salvar(usuarioRequest);
    }
}
