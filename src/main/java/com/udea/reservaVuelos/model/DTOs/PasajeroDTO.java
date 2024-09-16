package com.udea.reservaVuelos.model.DTOs;

public class PasajeroDTO {
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private String correo;
    private String telefono;

    // Atributos adicionales para ReservaPasajero
    private Boolean accesibilidad; // Booleano para indicar si se seleccionó accesibilidad
    private Boolean equipajeAdicional; // Booleano para indicar si se ha solicitado equipaje adicional
    private Boolean adiciones; // Booleano para indicar si se han solicitado adiciones
    private Boolean asientoElegido; // Booleano para indicar si se ha elegido un asiento

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(Boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public Boolean getEquipajeAdicional() {
        return equipajeAdicional;
    }

    public void setEquipajeAdicional(Boolean equipajeAdicional) {
        this.equipajeAdicional = equipajeAdicional;
    }

    public Boolean getAdiciones() {
        return adiciones;
    }

    public void setAdiciones(Boolean adiciones) {
        this.adiciones = adiciones;
    }

    public Boolean getAsientoElegido() {
        return asientoElegido;
    }

    public void setAsientoElegido(Boolean asientoElegido) {
        this.asientoElegido = asientoElegido;
    }
}
