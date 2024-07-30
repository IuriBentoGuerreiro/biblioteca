package com.example.projeto.biblioteca.controller;

import com.example.projeto.biblioteca.dto.emprestimo.EmprestimoRequest;
import com.example.projeto.biblioteca.dto.emprestimo.EmprestimoResponse;
import com.example.projeto.biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public EmprestimoResponse save(@RequestBody EmprestimoRequest emprestimoRequest){
        return emprestimoService.salvar(emprestimoRequest);
    }
}
