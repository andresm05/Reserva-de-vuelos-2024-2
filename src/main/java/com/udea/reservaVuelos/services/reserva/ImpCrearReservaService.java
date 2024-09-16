package com.udea.reservaVuelos.services.reserva;
import com.udea.reservaVuelos.model.DTOs.PasajeroDTO;
import com.udea.reservaVuelos.model.DTOs.ReservaDTO;
import com.udea.reservaVuelos.model.entities.Pasajero;
import com.udea.reservaVuelos.model.entities.Reserva;
import com.udea.reservaVuelos.model.entities.ReservaPasajero;
import com.udea.reservaVuelos.repository.ReservaPasajeroRepository;
import com.udea.reservaVuelos.repository.ReservaRepository;
import com.udea.reservaVuelos.services.pasajero.CrearPasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImpCrearReservaService implements CrearReservaService{
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private CrearPasajeroService crearPasajeroService;

    @Autowired
    private ReservaPasajeroRepository reservaPasajeroRepository;

    @Transactional
    @Override
    public Reserva crearReserva(ReservaDTO reservaDTO) {
        if (reservaDTO == null || reservaDTO.getPasajeros() == null || reservaDTO.getPasajeros().isEmpty()) {
            throw new IllegalArgumentException("La reserva debe incluir al menos un pasajero.");
        }

        Reserva reserva = new Reserva();
        reserva.setNumeroReserva(reservaDTO.getNumeroReserva());
        reserva.setFechaReserva(reservaDTO.getFechaReserva());
        reserva.setNumeroPasajeros(reservaDTO.getNumeroPasajeros());

        Reserva reservaGuardada = reservaRepository.save(reserva);

        for (PasajeroDTO pasajeroDTO : reservaDTO.getPasajeros()) {
            Pasajero pasajeroGuardado = crearPasajeroService.crearPasajero(pasajeroDTO);

            ReservaPasajero reservaPasajero = new ReservaPasajero();
            reservaPasajero.setReserva(reservaGuardada);
            reservaPasajero.setPasajero(pasajeroGuardado);
            reservaPasajero.setAccesibilidad(pasajeroDTO.getAccesibilidad());
            reservaPasajero.setEquipajeAdicional(pasajeroDTO.getEquipajeAdicional());
            reservaPasajero.setAdiciones(pasajeroDTO.getAdiciones());
            reservaPasajero.setAsientoElegido(pasajeroDTO.getAsientoElegido());

            reservaPasajeroRepository.save(reservaPasajero);
        }

        return reservaGuardada;
    }
}
