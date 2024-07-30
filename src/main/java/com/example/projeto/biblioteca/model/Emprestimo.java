package com.example.projeto.biblioteca.model;

import com.example.projeto.biblioteca.dto.emprestimo.EmprestimoRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @Column(name = "data_emprestimo")
    private LocalDate dataEmprestimo;

    @Column(name = "data_devolucao_prevista")
    private LocalDate dataDevolucaoPrevista;

    @Column(name = "data_devolucao_real")
    private LocalDate dataDevolucaoReal;

    @Column(name = "multa")
    private BigDecimal multa;

    public static Emprestimo converter(EmprestimoRequest emprestimoRequest) {
        return Emprestimo.builder()
                .usuario(new Usuario(emprestimoRequest.getUsuarioId()))
                .livro(new Livro(emprestimoRequest.getLivroId()))
                .dataEmprestimo(emprestimoRequest.getDataEmprestimo())
                .dataDevolucaoPrevista(emprestimoRequest.getDataDevolucaoPrevista())
                .dataDevolucaoReal(emprestimoRequest.getDataDevolucaoReal())
                .multa(emprestimoRequest.getMulta())
                .build();
    }
}
