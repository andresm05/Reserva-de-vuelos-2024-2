package com.udea.reservaVuelos.model.entities;

public class ErrorResponse {
    private int statusCode;
    private String mensaje;
    private String details;

    public ErrorResponse(int statusCode, String mensaje, String details) {
        this.statusCode = statusCode;
        this.mensaje = mensaje;
        this.details = details;
    }

    // Getters y setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
