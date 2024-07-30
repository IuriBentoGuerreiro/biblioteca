package com.example.projeto.biblioteca.model;

import com.example.projeto.biblioteca.dto.ReservaRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "reserva")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @Column(name = "data_reserva")
    private LocalDate dataReserva;

    @Column(name = "data_notificacao")
    private LocalDate dataNotificacao;

    private Reserva converter(ReservaRequest reservaRequest){
        return Reserva.builder()
                .usuario(new Usuario(reservaRequest.getUsuarioId()))
                .livro(new Livro(reservaRequest.getLivroId()))
                .dataReserva(reservaRequest.getDataReserva())
                .dataNotificacao(reservaRequest.getDataNotificacao())
                .build();
    }
}
