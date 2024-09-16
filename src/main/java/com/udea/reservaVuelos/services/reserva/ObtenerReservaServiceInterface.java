package com.udea.reservaVuelos.services.reserva;

import com.udea.reservaVuelos.model.entities.ReservaPasajero;

import java.util.List;

public interface ObtenerReservaServiceInterface {

    List<ReservaPasajero> obtenerReservaPorNumeroReservaYNumeroDocumento(String numeroReserva, String numeroDocumento);
}