package com.udea.reservaVuelos.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva_pasajero")
public class ReservaPasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva_pasajero")
    private Long idReservaPasajero; // PK idReservaPasajero

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva; // FK idReserva

    @ManyToOne
    @JoinColumn(name = "id_pasajero", nullable = false)
    private Pasajero pasajero; // FK idPasajero

    @Column(name = "accesibilidad")
    private boolean accesibilidad; // accesibilidad

    @Column(name = "equipaje_adicional")
    private boolean equipajeAdicional; // equipajeAdicional

    @Column(name = "adiciones")
    private boolean adiciones; // adiciones

    @Column(name = "asiento_elegido")
    private boolean asientoElegido; // asientoElegido

    // Constructor
    public ReservaPasajero() {
    }

    public ReservaPasajero(Long idReservaPasajero, Reserva reserva, Pasajero pasajero, boolean accesibilidad, boolean equipajeAdicional, boolean adiciones, boolean asientoElegido) {
        this.idReservaPasajero = idReservaPasajero;
        this.reserva = reserva;
        this.pasajero = pasajero;
        this.accesibilidad = accesibilidad;
        this.equipajeAdicional = equipajeAdicional;
        this.adiciones = adiciones;
        this.asientoElegido = asientoElegido;
    }

    // Getters y Setters
    public Long getIdReservaPasajero() {
        return idReservaPasajero;
    }

    public void setIdReservaPasajero(Long idReservaPasajero) {
        this.idReservaPasajero = idReservaPasajero;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public boolean isAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public boolean isEquipajeAdicional() {
        return equipajeAdicional;
    }

    public void setEquipajeAdicional(boolean equipajeAdicional) {
        this.equipajeAdicional = equipajeAdicional;
    }

    public boolean isAdiciones() {
        return adiciones;
    }

    public void setAdiciones(boolean adiciones) {
        this.adiciones = adiciones;
    }

    public boolean isAsientoElegido() {
        return asientoElegido;
    }

    public void setAsientoElegido(boolean asientoElegido) {
        this.asientoElegido = asientoElegido;
    }

    @Override
    public String toString() {
        return "ReservaPasajero{" +
                "idReservaPasajero=" + idReservaPasajero +
                ", reserva=" + reserva +
                ", pasajero=" + pasajero +
                ", accesibilidad=" + accesibilidad +
                ", equipajeAdicional=" + equipajeAdicional +
                ", adiciones=" + adiciones +
                ", asientoElegido=" + asientoElegido +
                '}';
    }
}
