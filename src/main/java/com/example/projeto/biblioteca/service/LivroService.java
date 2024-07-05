package com.example.projeto.biblioteca.service;

import com.example.projeto.biblioteca.dto.LivroRequest;
import com.example.projeto.biblioteca.dto.LivroResponse;
import com.example.projeto.biblioteca.model.Livro;
import com.example.projeto.biblioteca.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroResponse salvar(LivroRequest livroRequest){
        return LivroResponse.converter(livroRepository.save(Livro.converter(livroRequest)));
    }

    public List<LivroResponse> buscarTodos() {
        return livroRepository.findAll().stream()
                .map(LivroResponse::converter).toList();
    }

    public Livro pegarPorId(Integer id){
        return livroRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Recurso não encontrado")
        );
    }

    public Livro atualizar(Integer id, LivroRequest livroRequest){
        var livroAtualizado = pegarPorId(id);
        BeanUtils.copyProperties(livroRequest, livroAtualizado, "id");
        return livroRepository.save(livroAtualizado);
    }

    public void deletar(Integer id){
        livroRepository.deleteById(id);
    }

}
