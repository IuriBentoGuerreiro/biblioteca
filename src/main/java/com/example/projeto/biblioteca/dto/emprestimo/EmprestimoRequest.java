package com.example.projeto.biblioteca.dto.emprestimo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EmprestimoRequest {

    private Integer usuarioId;
    private Integer livroId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private BigDecimal multa;
}
