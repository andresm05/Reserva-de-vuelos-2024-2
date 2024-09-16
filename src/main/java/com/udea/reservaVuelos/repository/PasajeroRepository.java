package com.udea.reservaVuelos.repository;

import com.udea.reservaVuelos.model.entities.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
    @Query("SELECT p FROM Pasajero p WHERE p.numeroDocumento = :numeroDocumento")
    Optional<Pasajero> findByNumeroDocumento(@Param("numeroDocumento") String numeroDocumento);
}

