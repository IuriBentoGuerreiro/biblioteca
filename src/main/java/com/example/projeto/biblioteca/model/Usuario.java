package com.example.projeto.biblioteca.model;

import com.example.projeto.biblioteca.dto.EmprestimoRequest;
import com.example.projeto.biblioteca.dto.UsuarioRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Emprestimo> historicoEmprestimos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    public Usuario(Integer id){
        this.id = id;
    }

    public static Usuario converter(UsuarioRequest usuarioRequest) {
        return Usuario.builder()
                .nome(usuarioRequest.getNome())
                .endereco(usuarioRequest.getEndereco())
                .email(usuarioRequest.getEmail())
                .telefone(usuarioRequest.getTelefone())
                .dataNascimento(usuarioRequest.getDataNascimento())
                .dataCadastro(LocalDateTime.now())
                .build();
    }

}
