package com.example.projeto.biblioteca.service;

import com.example.projeto.biblioteca.dto.AutorRequest;
import com.example.projeto.biblioteca.dto.AutorResponse;
import com.example.projeto.biblioteca.model.Autor;
import com.example.projeto.biblioteca.repository.AutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorResponse salvar(AutorRequest autorRequest){
        return AutorResponse.converter(autorRepository.save(Autor.converter(autorRequest)));
    }

    public List<AutorResponse> listar(){
        return autorRepository.findAll().stream()
                .map(AutorResponse::converter).toList();
    }

    public Autor pegarPorId(Integer id){
        return autorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Recurso não encontrado")
        );
    }

    public Autor atualizar(Integer id, AutorRequest autorRequest){
        var autorAtualizado = pegarPorId(id);
        BeanUtils.copyProperties(autorRequest, autorAtualizado, "id");
        return autorRepository.save(autorAtualizado);
    }

    public void deletar(Integer id){
        autorRepository.deleteById(id);
    }

}
