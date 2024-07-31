package com.example.projeto.biblioteca.dto.emprestimo;

import com.example.projeto.biblioteca.model.Emprestimo;
import com.example.projeto.biblioteca.model.Livro;
import com.example.projeto.biblioteca.model.Usuario;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class EmprestimoResponse {

    private Integer id;
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private BigDecimal multa;

    public static EmprestimoResponse converter(Emprestimo emprestimo) {
        return EmprestimoResponse.builder()
                .id(emprestimo.getId())
                .usuario(emprestimo.getUsuario())
                .livro(emprestimo.getLivro())
                .dataEmprestimo(emprestimo.getDataEmprestimo())
                .dataDevolucaoPrevista(emprestimo.getDataDevolucaoPrevista())
                .dataDevolucaoReal(emprestimo.getDataDevolucaoReal())
                .multa(emprestimo.getMulta())
                .build();
    }
}
