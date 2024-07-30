package com.example.projeto.biblioteca.dto.usuario;

import com.example.projeto.biblioteca.model.Emprestimo;
import com.example.projeto.biblioteca.model.Reserva;
import com.example.projeto.biblioteca.model.Usuario;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class UsuarioResponse {

    private Integer id;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDateTime dataCadastro;
    private List<Emprestimo> historicoEmprestimos;
    private List<Reserva> reservas;

    public UsuarioResponse converter(Usuario usuario){
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .endereco(usuario.getEndereco())
                .email(usuario.getEmail())
                .telefone(usuario.getTelefone())
                .dataNascimento(usuario.getDataNascimento())
                .dataCadastro(usuario.getDataCadastro())
                .historicoEmprestimos(usuario.getHistoricoEmprestimos())
                .reservas(usuario.getReservas())
                .build();
    }
}
