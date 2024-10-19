package com.udea.reservaVuelos.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udea.reservaVuelos.model.DTOs.ReservaDTO;
import com.udea.reservaVuelos.model.entities.Reserva;
import com.udea.reservaVuelos.model.entities.ReservaPasajero;
import com.udea.reservaVuelos.services.reserva.CrearReservaService;
import com.udea.reservaVuelos.services.reserva.ObtenerReservaServiceInterface;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "http://localhost:3000, https://code-factory-2024-front.vercel.app")
public class ReservaController {
    private static final Logger logger = LoggerFactory.getLogger(ReservaController.class);
    @Autowired
    private CrearReservaService crearReservaService;

    @Autowired
    private ObtenerReservaServiceInterface obtenerReservaService;

    @PostMapping("/crear")
    public ResponseEntity<Reserva> crearReserva(@RequestBody ReservaDTO reservaDTO) {
        try {
            Reserva reservaCreada = crearReservaService.crearReserva(reservaDTO);
            return new ResponseEntity<>(reservaCreada, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error en la solicitud de reserva: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error interno del servidor: " + e.getMessage());
        }
    }

    @GetMapping("/obtenerReserva")
    public ResponseEntity<?> obtenerReserva(@RequestParam("numeroReserva") String numeroReserva,
                                            @RequestParam("numeroDocumento") String numeroDocumento) {
        try {
            List<ReservaPasajero> reservasPasajeros = obtenerReservaService.obtenerReservaPorNumeroReservaYNumeroDocumento(numeroReserva, numeroDocumento);
            if (reservasPasajeros.isEmpty()) {
                return new ResponseEntity<>("No se encontraron reservas para los parámetros proporcionados.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(reservasPasajeros, HttpStatus.OK);
        } catch (RuntimeException e) {
            logger.error("Error al obtener la reserva", e);
            return new ResponseEntity<>("Error al obtener la reserva: " + e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error interno del servidor", e);
            return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
