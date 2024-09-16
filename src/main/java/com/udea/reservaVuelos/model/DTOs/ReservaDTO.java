package com.udea.reservaVuelos.model.DTOs;

import java.util.Date;
import java.util.List;

public class ReservaDTO {
    private Long idVueloIda;
    private Long idVueloVuelta;
    private String numeroReserva;
    private Date fechaReserva;
    private Integer numeroPasajeros;
    private List<PasajeroDTO> pasajeros;

    // Getters y Setters
    public Long getIdVueloIda() {
        return idVueloIda;
    }

    public void setIdVueloIda(Long idVueloIda) {
        this.idVueloIda = idVueloIda;
    }

    public Long getIdVueloVuelta() {
        return idVueloVuelta;
    }

    public void setIdVueloVuelta(Long idVueloVuelta) {
        this.idVueloVuelta = idVueloVuelta;
    }

    public String getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(String numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Integer getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(Integer numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public List<PasajeroDTO> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<PasajeroDTO> pasajeros) {
        this.pasajeros = pasajeros;
    }
}
