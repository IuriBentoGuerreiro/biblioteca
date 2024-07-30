package com.example.projeto.biblioteca.service;

import com.example.projeto.biblioteca.dto.emprestimo.EmprestimoRequest;
import com.example.projeto.biblioteca.dto.emprestimo.EmprestimoResponse;
import com.example.projeto.biblioteca.model.Emprestimo;
import com.example.projeto.biblioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final UsuarioService usuarioService;
    private final LivroService livroService;

    @Autowired
    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             UsuarioService usuarioService,
                             LivroService livroService) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioService = usuarioService;
        this.livroService = livroService;
    }

    public EmprestimoResponse salvar(EmprestimoRequest emprestimoRequest){
        var emprestimo = emprestimoRepository.save(Emprestimo.builder()
                        .usuario(usuarioService.pegarPorId(emprestimoRequest.getUsuarioId()))
                        .livro(livroService.pegarPorId(emprestimoRequest.getLivroId()))
                        .dataEmprestimo(emprestimoRequest.getDataEmprestimo())
                        .dataDevolucaoPrevista(emprestimoRequest.getDataDevolucaoPrevista())
                        .dataDevolucaoReal(emprestimoRequest.getDataDevolucaoReal())
                .build());

        return EmprestimoResponse.converter(emprestimo);
    }
}
