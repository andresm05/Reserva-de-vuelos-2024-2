// package com.udea.reservaVuelos.pasajero;

// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import static org.mockito.ArgumentMatchers.any;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;
// import org.mockito.MockitoAnnotations;
// import org.springframework.test.context.ActiveProfiles;

// import com.udea.reservaVuelos.model.DTOs.PasajeroDTO;
// import com.udea.reservaVuelos.model.entities.Pasajero;
// import com.udea.reservaVuelos.repository.PasajeroRepository;
// import com.udea.reservaVuelos.services.pasajero.ImpCrearPasajeroService;

// @ActiveProfiles("test")
// class ImpCrearPasajeroServiceTest {

//     @InjectMocks
//     private ImpCrearPasajeroService crearPasajeroService;

//     @Mock
//     private PasajeroRepository pasajeroRepository;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @DisplayName("Test Crear Pasajero nulo")
//     @Test
//     void testCrearPasajero_NullDTO() {
//         Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//             crearPasajeroService.crearPasajero(null);
//         });

//         assertEquals("El DTO del pasajero no puede ser nulo.", exception.getMessage());
//     }

//     @DisplayName("Test Crear Pasajero válido")
//     @Test
//     void testCrearPasajero_ValidDTO() {
//         PasajeroDTO pasajeroDTO = new PasajeroDTO();
//         pasajeroDTO.setNombre("Juan");
//         pasajeroDTO.setApellido("Pérez");
//         pasajeroDTO.setTipoDocumento("CC");
//         pasajeroDTO.setNumeroDocumento("123456789");
//         pasajeroDTO.setCorreo("juan.perez@example.com");
//         pasajeroDTO.setTelefono("1234567890");

//         Pasajero pasajero = new Pasajero();
//         pasajero.setNombre("Juan");
//         pasajero.setApellido("Pérez");
//         pasajero.setTipoDocumento("CC");
//         pasajero.setNumeroDocumento("123456789");
//         pasajero.setCorreo("juan.perez@example.com");
//         pasajero.setTelefono("1234567890");

//         when(pasajeroRepository.save(any(Pasajero.class))).thenReturn(pasajero);

//         Pasajero result = crearPasajeroService.crearPasajero(pasajeroDTO);

//         assertNotNull(result);
//         assertEquals("Juan", result.getNombre());
//         verify(pasajeroRepository, times(1)).save(any(Pasajero.class));
//     }

//     @DisplayName("Test Crear Pasajeros nulo o vacío")
//     @Test
//     void testCrearPasajeros_NullOrEmptyList() {
//         Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
//             crearPasajeroService.crearPasajeros(null);
//         });
//         assertEquals("La lista de pasajeros no puede ser nula o vacía.", exception1.getMessage());

//         Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
//             crearPasajeroService.crearPasajeros(Collections.emptyList());
//         });
//         assertEquals("La lista de pasajeros no puede ser nula o vacía.", exception2.getMessage());
//     }

//     @DisplayName("Test Crear Pasajeros válidos")
//     @Test
//     void testCrearPasajeros_ValidList() {
//         PasajeroDTO pasajeroDTO1 = new PasajeroDTO();
//         pasajeroDTO1.setNombre("Juan");
//         pasajeroDTO1.setApellido("Pérez");
//         pasajeroDTO1.setTipoDocumento("CC");
//         pasajeroDTO1.setNumeroDocumento("123456789");
//         pasajeroDTO1.setCorreo("juan.perez@example.com");
//         pasajeroDTO1.setTelefono("1234567890");

//         PasajeroDTO pasajeroDTO2 = new PasajeroDTO();
//         pasajeroDTO2.setNombre("Ana");
//         pasajeroDTO2.setApellido("Gómez");
//         pasajeroDTO2.setTipoDocumento("CC");
//         pasajeroDTO2.setNumeroDocumento("987654321");
//         pasajeroDTO2.setCorreo("ana.gomez@example.com");
//         pasajeroDTO2.setTelefono("0987654321");

//         Pasajero pasajero1 = new Pasajero();
//         pasajero1.setNombre("Juan");
//         pasajero1.setApellido("Pérez");
//         pasajero1.setTipoDocumento("CC");
//         pasajero1.setNumeroDocumento("123456789");
//         pasajero1.setCorreo("juan.perez@example.com");
//         pasajero1.setTelefono("1234567890");

//         Pasajero pasajero2 = new Pasajero();
//         pasajero2.setNombre("Ana");
//         pasajero2.setApellido("Gómez");
//         pasajero2.setTipoDocumento("CC");
//         pasajero2.setNumeroDocumento("987654321");
//         pasajero2.setCorreo("ana.gomez@example.com");
//         pasajero2.setTelefono("0987654321");

//         when(pasajeroRepository.save(any(Pasajero.class))).thenReturn(pasajero1, pasajero2);

//         List<Pasajero> result = crearPasajeroService.crearPasajeros(Arrays.asList(pasajeroDTO1, pasajeroDTO2));

//         assertNotNull(result);
//         assertEquals(2, result.size());
//         assertEquals("Juan", result.get(0).getNombre());
//         assertEquals("Ana", result.get(1).getNombre());
//         verify(pasajeroRepository, times(2)).save(any(Pasajero.class));
//     }
// }
