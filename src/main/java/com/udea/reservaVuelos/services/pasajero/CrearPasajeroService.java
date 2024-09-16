package com.udea.reservaVuelos.services.pasajero;

import com.udea.reservaVuelos.model.DTOs.PasajeroDTO;
import com.udea.reservaVuelos.model.entities.Pasajero;

import java.util.List;

public interface CrearPasajeroService {
    Pasajero crearPasajero(PasajeroDTO pasajeroDTO);
    List<Pasajero> crearPasajeros(List<PasajeroDTO> pasajerosDTO);
}