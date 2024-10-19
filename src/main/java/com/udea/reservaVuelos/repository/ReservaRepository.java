package com.udea.reservaVuelos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.udea.reservaVuelos.model.entities.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("SELECT r FROM Reserva r WHERE r.numeroReserva = :numeroReserva")
    Optional<Reserva> findByNumeroReserva(@Param("numeroReserva") String numeroReserva);
}
