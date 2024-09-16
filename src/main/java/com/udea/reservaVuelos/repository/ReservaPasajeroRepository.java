package com.udea.reservaVuelos.repository;
import com.udea.reservaVuelos.model.entities.ReservaPasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaPasajeroRepository extends JpaRepository<ReservaPasajero, Long>{
    List<ReservaPasajero> findByReserva_IdReservaAndPasajero_IdPasajero(Long idReserva, Long idPasajero);
}





