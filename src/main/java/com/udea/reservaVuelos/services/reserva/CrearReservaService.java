package com.udea.reservaVuelos.services.reserva;

import com.udea.reservaVuelos.model.DTOs.ReservaDTO;
import com.udea.reservaVuelos.model.entities.Reserva;

public interface CrearReservaService {
    Reserva crearReserva(ReservaDTO reservaDTO);
}
