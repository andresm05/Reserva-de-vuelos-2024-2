package com.udea.reservaVuelos.reserva;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import com.udea.reservaVuelos.model.DTOs.PasajeroDTO;
import com.udea.reservaVuelos.model.DTOs.ReservaDTO;
import com.udea.reservaVuelos.model.entities.Pasajero;
import com.udea.reservaVuelos.model.entities.Reserva;
import com.udea.reservaVuelos.model.entities.ReservaPasajero;
import com.udea.reservaVuelos.repository.ReservaPasajeroRepository;
import com.udea.reservaVuelos.repository.ReservaRepository;
import com.udea.reservaVuelos.services.pasajero.CrearPasajeroService;
import com.udea.reservaVuelos.services.reserva.ImpCrearReservaService;

class ImpCrearReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private CrearPasajeroService crearPasajeroService;

    @Mock
    private ReservaPasajeroRepository reservaPasajeroRepository;

    @InjectMocks
    private ImpCrearReservaService impCrearReservaService;

    private ReservaDTO reservaDTO;
    private PasajeroDTO pasajeroDTO;
    private Reserva reserva;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Configuración de objetos de prueba
        pasajeroDTO = new PasajeroDTO();
        pasajeroDTO.setAccesibilidad(true);
        pasajeroDTO.setEquipajeAdicional(true);
        pasajeroDTO.setAdiciones(true);
        pasajeroDTO.setAsientoElegido(true);

        List<PasajeroDTO> pasajeros = new ArrayList<>();
        pasajeros.add(pasajeroDTO);

        reservaDTO = new ReservaDTO();
        reservaDTO.setNumeroReserva("58H");
        reservaDTO.setFechaReserva(new Date());
        reservaDTO.setNumeroPasajeros(1);
        reservaDTO.setPasajeros(pasajeros);

        reserva = new Reserva();
        reserva.setIdReserva(1L);
        reserva.setNumeroReserva("58H");
        reserva.setFechaReserva(new Date());
        reserva.setNumeroPasajeros(1);
    }

    @DisplayName("Debe crear una reserva con un pasajero exitosamente")
    @Test
    void testCrearReservaConPasajeroExitosamente() {
        // Mocks
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);
        when(crearPasajeroService.crearPasajero(any(PasajeroDTO.class))).thenReturn(new Pasajero());
        when(reservaPasajeroRepository.save(any(ReservaPasajero.class))).thenReturn(new ReservaPasajero());

        // Acción
        Reserva reservaGuardada = impCrearReservaService.crearReserva(reservaDTO);

        // Verificación
        assertNotNull(reservaGuardada);
        verify(reservaRepository, times(1)).save(any(Reserva.class));
        verify(crearPasajeroService, times(1)).crearPasajero(any(PasajeroDTO.class));
        verify(reservaPasajeroRepository, times(1)).save(any(ReservaPasajero.class));
    }

    @DisplayName("Debe lanzar IllegalArgumentException cuando la reserva no incluye pasajeros")
    @Test
    void testCrearReservaSinPasajerosDebeLanzarExcepcion() {
        // Configuración de reserva sin pasajeros
        reservaDTO.setPasajeros(new ArrayList<>());

        // Verificación
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            impCrearReservaService.crearReserva(reservaDTO);
        });

        assertEquals("La reserva debe incluir al menos un pasajero.", exception.getMessage());
        verifyNoInteractions(reservaRepository);
    }

    @DisplayName("Debe lanzar IllegalArgumentException cuando el objeto reservaDTO es nulo")
    @Test
    void testCrearReservaConReservaDTONuloDebeLanzarExcepcion() {
        // Verificación
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            impCrearReservaService.crearReserva(null);
        });

        assertEquals("La reserva debe incluir al menos un pasajero.", exception.getMessage());
        verifyNoInteractions(reservaRepository);
    }

    @DisplayName("Debe lanzar una excepción si la reserva no se guarda correctamente")
    @Test
    void testErrorAlGuardarReserva() {
        // Simulación de error al guardar la reserva
        when(reservaRepository.save(any(Reserva.class))).thenThrow(new InvalidDataAccessApiUsageException("Error de acceso"));

        // Verificación
        InvalidDataAccessApiUsageException exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> {
            impCrearReservaService.crearReserva(reservaDTO);
        });

        assertEquals("Error de acceso", exception.getMessage());
        verify(reservaRepository, times(1)).save(any(Reserva.class));
    }
}