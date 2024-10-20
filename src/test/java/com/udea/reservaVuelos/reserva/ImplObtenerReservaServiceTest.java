// package com.udea.reservaVuelos.reserva;


// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import static org.mockito.ArgumentMatchers.anyLong;
// import static org.mockito.ArgumentMatchers.anyString;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.verifyNoMoreInteractions;
// import static org.mockito.Mockito.when;
// import org.mockito.MockitoAnnotations;
// import org.springframework.test.context.ActiveProfiles;

// import com.udea.reservaVuelos.model.entities.Pasajero;
// import com.udea.reservaVuelos.model.entities.Reserva;
// import com.udea.reservaVuelos.model.entities.ReservaPasajero;
// import com.udea.reservaVuelos.repository.PasajeroRepository;
// import com.udea.reservaVuelos.repository.ReservaPasajeroRepository;
// import com.udea.reservaVuelos.repository.ReservaRepository;
// import com.udea.reservaVuelos.services.reserva.ImplObtenerReservaService;

// @ActiveProfiles("test")
// class ImplObtenerReservaServiceTest {

//     @Mock
//     private ReservaRepository reservaRepository;

//     @Mock
//     private PasajeroRepository pasajeroRepository;

//     @Mock
//     private ReservaPasajeroRepository reservaPasajeroRepository;

//     @InjectMocks
//     private ImplObtenerReservaService obtenerReservaService;

//     private Reserva reserva;
//     private Pasajero pasajero;
//     private List<ReservaPasajero> reservasPasajeros;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);

//         // Configuración de objetos de prueba
//         reserva = new Reserva();
//         reserva.setIdReserva(1L);
//         reserva.setNumeroReserva("58H");

//         pasajero = new Pasajero();
//         pasajero.setIdPasajero(1L);
//         pasajero.setNumeroDocumento("123456");

//         ReservaPasajero reservaPasajero = new ReservaPasajero();
//         reservaPasajero.setReserva(reserva);
//         reservaPasajero.setPasajero(pasajero);

//         reservasPasajeros = new ArrayList<>();
//         reservasPasajeros.add(reservaPasajero);
//     }

//     @DisplayName("Debe obtener una reserva por número de reserva y número de documento")
//     @Test
//     void testObtenerReservaPorNumeroReservaYNumeroDocumentoExitosamente() {
//         // Mocks
//         when(reservaRepository.findByNumeroReserva(anyString())).thenReturn(Optional.of(reserva));
//         when(pasajeroRepository.findByNumeroDocumento(anyString())).thenReturn(Optional.of(pasajero));
//         when(reservaPasajeroRepository.findByReserva_IdReservaAndPasajero_IdPasajero(anyLong(), anyLong()))
//             .thenReturn(reservasPasajeros);

//         // Acción
//         List<ReservaPasajero> resultado = obtenerReservaService.obtenerReservaPorNumeroReservaYNumeroDocumento("58H", "123456");

//         // Verificación
//         assertNotNull(resultado);
//         assertFalse(resultado.isEmpty());
//         assertEquals(1, resultado.size());
//         assertEquals(reserva.getIdReserva(), resultado.get(0).getReserva().getIdReserva());
//         assertEquals(pasajero.getIdPasajero(), resultado.get(0).getPasajero().getIdPasajero());

//         verify(reservaRepository, times(1)).findByNumeroReserva(anyString());
//         verify(pasajeroRepository, times(1)).findByNumeroDocumento(anyString());
//         verify(reservaPasajeroRepository, times(1))
//             .findByReserva_IdReservaAndPasajero_IdPasajero(anyLong(), anyLong());
//     }

//     @DisplayName("Debe lanzar excepción si no se encuentra la reserva por número de reserva")
//     @Test
//     void testReservaNoEncontradaDebeLanzarExcepcion() {
//         // Mocks
//         when(reservaRepository.findByNumeroReserva(anyString())).thenReturn(Optional.empty());

//         // Verificación
//         RuntimeException exception = assertThrows(RuntimeException.class, () -> {
//             obtenerReservaService.obtenerReservaPorNumeroReservaYNumeroDocumento("58H", "123456");
//         });

//         assertEquals("Reserva no encontrada para el número de reserva proporcionado", exception.getMessage());
//         verify(reservaRepository, times(1)).findByNumeroReserva(anyString());
//         verifyNoMoreInteractions(pasajeroRepository, reservaPasajeroRepository);
//     }

//     @DisplayName("Debe lanzar excepción si no se encuentra el pasajero por número de documento")
//     @Test
//     void testPasajeroNoEncontradoDebeLanzarExcepcion() {
//         // Mocks
//         when(reservaRepository.findByNumeroReserva(anyString())).thenReturn(Optional.of(reserva));
//         when(pasajeroRepository.findByNumeroDocumento(anyString())).thenReturn(Optional.empty());

//         // Verificación
//         RuntimeException exception = assertThrows(RuntimeException.class, () -> {
//             obtenerReservaService.obtenerReservaPorNumeroReservaYNumeroDocumento("58H", "123456");
//         });

//         assertEquals("Pasajero no encontrado para el número de documento proporcionado", exception.getMessage());
//         verify(reservaRepository, times(1)).findByNumeroReserva(anyString());
//         verify(pasajeroRepository, times(1)).findByNumeroDocumento(anyString());
//         verifyNoMoreInteractions(reservaPasajeroRepository);
//     }

//     @DisplayName("Debe lanzar excepción si no se encuentran datos en ReservaPasajero")
//     @Test
//     void testNoSeEncuentraReservaPasajeroDebeLanzarExcepcion() {
//         // Mocks
//         when(reservaRepository.findByNumeroReserva(anyString())).thenReturn(Optional.of(reserva));
//         when(pasajeroRepository.findByNumeroDocumento(anyString())).thenReturn(Optional.of(pasajero));
//         when(reservaPasajeroRepository.findByReserva_IdReservaAndPasajero_IdPasajero(anyLong(), anyLong()))
//             .thenReturn(new ArrayList<>());

//         // Verificación
//         RuntimeException exception = assertThrows(RuntimeException.class, () -> {
//             obtenerReservaService.obtenerReservaPorNumeroReservaYNumeroDocumento("58H", "123456");
//         });

//         assertEquals("No se encontraron datos de reserva para el pasajero con los IDs proporcionados", exception.getMessage());
//         verify(reservaRepository, times(1)).findByNumeroReserva(anyString());
//         verify(pasajeroRepository, times(1)).findByNumeroDocumento(anyString());
//         verify(reservaPasajeroRepository, times(1))
//             .findByReserva_IdReservaAndPasajero_IdPasajero(anyLong(), anyLong());
//     }
// }