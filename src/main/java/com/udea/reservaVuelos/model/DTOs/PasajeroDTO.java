package com.udea.reservaVuelos.model.DTOs;

import lombok.Data;

@Data
public class PasajeroDTO {
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private String correo;
    private String telefono;

    // Atributos adicionales para ReservaPasajero
    private Boolean accesibilidad;
    private Boolean equipajeAdicional;
    private Boolean adiciones;
    private Boolean asientoElegido;
}