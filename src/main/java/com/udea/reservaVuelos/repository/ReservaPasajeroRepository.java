package com.udea.reservaVuelos.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.reservaVuelos.model.entities.ReservaPasajero;

@Repository
public interface ReservaPasajeroRepository extends JpaRepository<ReservaPasajero, Long>{
    List<ReservaPasajero> findByReserva_IdReservaAndPasajero_IdPasajero(Long idReserva, Long idPasajero);
}





