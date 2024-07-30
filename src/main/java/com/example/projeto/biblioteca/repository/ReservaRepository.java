package com.example.projeto.biblioteca.repository;

import com.example.projeto.biblioteca.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
