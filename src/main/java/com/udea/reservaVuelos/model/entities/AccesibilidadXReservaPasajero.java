package com.udea.reservaVuelos.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "accesibilidad_x_reserva_pasajero")
public class AccesibilidadXReservaPasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_accesibilidad_x_reserva_pasajero")
    private Long idAccesibilidadXReservaPasajero; // PK idAccesibilidadXReservaPasajero

    @ManyToOne
    @JoinColumn(name = "id_accesibilidad", nullable = false)
    private Accesibilidad accesibilidad; // FK idAccesibilidad

    @ManyToOne
    @JoinColumn(name = "id_reserva_pasajero", nullable = false)
    private ReservaPasajero reservaPasajero; // FK idReservaPasajero

    // Constructor
    public AccesibilidadXReservaPasajero() {
    }

    public AccesibilidadXReservaPasajero(Long idAccesibilidadXReservaPasajero, Accesibilidad accesibilidad, ReservaPasajero reservaPasajero) {
        this.idAccesibilidadXReservaPasajero = idAccesibilidadXReservaPasajero;
        this.accesibilidad = accesibilidad;
        this.reservaPasajero = reservaPasajero;
    }

    // Getters y Setters
    public Long getIdAccesibilidadXReservaPasajero() {
        return idAccesibilidadXReservaPasajero;
    }

    public void setIdAccesibilidadXReservaPasajero(Long idAccesibilidadXReservaPasajero) {
        this.idAccesibilidadXReservaPasajero = idAccesibilidadXReservaPasajero;
    }

    public Accesibilidad getAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(Accesibilidad accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public ReservaPasajero getReservaPasajero() {
        return reservaPasajero;
    }

    public void setReservaPasajero(ReservaPasajero reservaPasajero) {
        this.reservaPasajero = reservaPasajero;
    }

    @Override
    public String toString() {
        return "AccesibilidadXReservaPasajero{" +
                "idAccesibilidadXReservaPasajero=" + idAccesibilidadXReservaPasajero +
                ", accesibilidad=" + accesibilidad +
                ", reservaPasajero=" + reservaPasajero +
                '}';
    }
}
