package com.udea.reservaVuelos.reserva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.udea.reservaVuelos.controllers.ReservaController;
import com.udea.reservaVuelos.model.DTOs.ReservaDTO;
import com.udea.reservaVuelos.model.entities.Reserva;
import com.udea.reservaVuelos.model.entities.ReservaPasajero;
import com.udea.reservaVuelos.services.reserva.CrearReservaService;
import com.udea.reservaVuelos.services.reserva.ObtenerReservaServiceInterface;

class ReservaControllerTest {

    @InjectMocks
    private ReservaController reservaController;

    @Mock
    private CrearReservaService crearReservaService;

    @Mock
    private ObtenerReservaServiceInterface obtenerReservaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearReserva_Success() {
        // Arrange
        ReservaDTO reservaDTO = new ReservaDTO();
        Reserva reserva = new Reserva();
        when(crearReservaService.crearReserva(reservaDTO)).thenReturn(reserva);

        // Act
        ResponseEntity<Reserva> response = reservaController.crearReserva(reservaDTO);

        // Assert
        assertEquals(CREATED, response.getStatusCode());
        assertEquals(reserva, response.getBody());
    }

    @Test
    void testCrearReserva_IllegalArgumentException() {
        // Arrange
        ReservaDTO reservaDTO = new ReservaDTO();
        when(crearReservaService.crearReserva(reservaDTO))
            .thenThrow(new IllegalArgumentException("Datos inválidos"));

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> reservaController.crearReserva(reservaDTO));

        assertEquals("Error en la solicitud de reserva: Datos inválidos", exception.getMessage());
    }

    @Test
    void testCrearReserva_RuntimeException() {
        // Arrange
        ReservaDTO reservaDTO = new ReservaDTO();
        when(crearReservaService.crearReserva(reservaDTO))
            .thenThrow(new RuntimeException("Error interno"));

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, 
            () -> reservaController.crearReserva(reservaDTO));

        assertEquals("Error interno del servidor: Error interno", exception.getMessage());
    }

    @Test
    void testObtenerReserva_Success() {
        // Arrange
        String numeroReserva = "123";
        String numeroDocumento = "456";
        List<ReservaPasajero> reservas = new ArrayList<>();
        reservas.add(new ReservaPasajero());
        when(obtenerReservaService.obtenerReservaPorNumeroReservaYNumeroDocumento(numeroReserva, numeroDocumento))
            .thenReturn(reservas);

        // Act
        ResponseEntity<?> response = reservaController.obtenerReserva(numeroReserva, numeroDocumento);

        // Assert
        assertEquals(OK, response.getStatusCode());
        assertEquals(reservas, response.getBody());
    }

    @Test
    void testObtenerReserva_NotFound() {
        // Arrange
        String numeroReserva = "123";
        String numeroDocumento = "456";
        when(obtenerReservaService.obtenerReservaPorNumeroReservaYNumeroDocumento(numeroReserva, numeroDocumento))
            .thenReturn(new ArrayList<>());

        // Act
        ResponseEntity<?> response = reservaController.obtenerReserva(numeroReserva, numeroDocumento);

        // Assert
        assertEquals(NOT_FOUND, response.getStatusCode());
        assertEquals("No se encontraron reservas para los parámetros proporcionados.", response.getBody());
    }

    @Test
    void testObtenerReserva_RuntimeException() {
        // Arrange
        String numeroReserva = "123";
        String numeroDocumento = "456";
        when(obtenerReservaService.obtenerReservaPorNumeroReservaYNumeroDocumento(numeroReserva, numeroDocumento))
            .thenThrow(new RuntimeException("Error al obtener reserva"));

        // Act
        ResponseEntity<?> response = reservaController.obtenerReserva(numeroReserva, numeroDocumento);

        // Assert
        assertEquals(NOT_FOUND, response.getStatusCode());
        assertEquals("Error al obtener la reserva: Error al obtener reserva", response.getBody());
    }
}