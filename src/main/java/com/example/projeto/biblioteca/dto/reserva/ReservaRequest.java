package com.example.projeto.biblioteca.dto.reserva;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservaRequest {

    private Integer usuarioId;
    private Integer livroId;
    private LocalDate dataReserva;
    private LocalDate dataNotificacao;
}
