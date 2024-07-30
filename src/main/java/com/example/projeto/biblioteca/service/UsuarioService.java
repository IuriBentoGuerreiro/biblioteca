package com.example.projeto.biblioteca.service;

import com.example.projeto.biblioteca.dto.usuario.UsuarioRequest;
import com.example.projeto.biblioteca.dto.usuario.UsuarioResponse;
import com.example.projeto.biblioteca.model.Usuario;
import com.example.projeto.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponse salvar(UsuarioRequest usuarioRequest){
        return UsuarioResponse.converter(usuarioRepository.save(Usuario.converter(usuarioRequest)));
    }

    public Usuario pegarPorId(Integer id){
        return usuarioRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("recurso não encontrado"));
    }
}
