package com.example.projeto.biblioteca.dto.reserva;

import com.example.projeto.biblioteca.model.Livro;
import com.example.projeto.biblioteca.model.Reserva;
import com.example.projeto.biblioteca.model.Usuario;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservaResponse {

    private Integer id;
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataReserva;
    private LocalDate dataNotificacao;

    public ReservaResponse converter(Reserva reserva){
        return ReservaResponse.builder()
                .id(reserva.getId())
                .usuario(reserva.getUsuario())
                .livro(reserva.getLivro())
                .dataReserva(reserva.getDataReserva())
                .dataNotificacao(reserva.getDataNotificacao())
                .build();
    }
}
