package com.example.projeto.biblioteca.service;

import com.example.projeto.biblioteca.dto.LivroRequest;
import com.example.projeto.biblioteca.model.Livro;
import com.example.projeto.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro salvar(LivroRequest livroRequest){
        return livroRepository.save(Livro.converterParaLivro(livroRequest));
    }

    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

}
