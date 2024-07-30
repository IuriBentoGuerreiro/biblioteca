package com.example.projeto.biblioteca.service;

import com.example.projeto.biblioteca.dto.livro.LivroRequest;
import com.example.projeto.biblioteca.dto.livro.LivroResponse;
import com.example.projeto.biblioteca.model.Livro;
import com.example.projeto.biblioteca.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private final LivroRepository livroRepository;

    @Autowired
    private final AutorService autorService;

    public LivroService(LivroRepository livroRepository, AutorService autorService){
        this.livroRepository = livroRepository;
        this.autorService = autorService;
    }

    public LivroResponse salvar(LivroRequest livroRequest){
        var livro = livroRepository.save(Livro.builder()
                        .anoLancamento(livroRequest.getAnoLancamento())
                        .autor(autorService.pegarPorId(livroRequest.getAutor()))
                        .dataCadastro(LocalDateTime.now())
                        .genero(livroRequest.getGenero())
                        .isbn(livroRequest.getIsbn())
                        .titulo(livroRequest.getTitulo())
                        .sinopse(livroRequest.getSinopse())
                .build());

        return LivroResponse.converter(livro);
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
