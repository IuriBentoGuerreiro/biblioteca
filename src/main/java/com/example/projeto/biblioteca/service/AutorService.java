package com.example.projeto.biblioteca.service;

import com.example.projeto.biblioteca.dto.AutorRequest;
import com.example.projeto.biblioteca.dto.AutorResponse;
import com.example.projeto.biblioteca.model.Autor;
import com.example.projeto.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorResponse salvar (AutorRequest autorRequest){
        return AutorResponse.converter(autorRepository.save(Autor.converter(autorRequest)));
    }

}
