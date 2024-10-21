package com.udea.reservaVuelos.model.DTOs;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class PasajeroDTO {
    String nombre;
    String apellido;
    String tipoDocumento;
    String numeroDocumento;
    String correo;
    String telefono;

    Boolean accesibilidad;
    Boolean equipajeAdicional;
    Boolean adiciones;
    Boolean asientoElegido;
}