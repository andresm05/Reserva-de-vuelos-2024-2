package com.udea.reservaVuelos.model.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva; // PK idReserva

    @Column(name = "numero_reserva", nullable = false, unique = true)
    private String numeroReserva; // numeroReserva

    @Column(name = "fecha_reserva", nullable = false)
    private Date fechaReserva; // fechaReserva

    @Column(name = "numero_pasajeros", nullable = false)
    private int numeroPasajeros; // numeroPasajeros

    @Column(name = "id_vuelo_ida")
    private Long idVueloIda; // FK idVueloIda

    @Column(name = "id_vuelo_vuelta")
    private Long idVueloVuelta; // FK idVueloVuelta

    // Constructor
    public Reserva() {
    }

    public Reserva(Long idReserva, String numeroReserva, Date fechaReserva, int numeroPasajeros, Long idVueloIda, Long idVueloVuelta) {
        this.idReserva = idReserva;
        this.numeroReserva = numeroReserva;
        this.fechaReserva = fechaReserva;
        this.numeroPasajeros = numeroPasajeros;
        this.idVueloIda = idVueloIda;
        this.idVueloVuelta = idVueloVuelta;
    }

    // Getters y Setters
    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
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

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

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
}
