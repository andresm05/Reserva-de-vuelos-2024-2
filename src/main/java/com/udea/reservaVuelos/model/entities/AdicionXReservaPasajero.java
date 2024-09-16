package com.udea.reservaVuelos.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "adicion_x_reserva_pasajero")
public class AdicionXReservaPasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adicion_x_reserva_pasajero")
    private Long idAdicionXReservaPasajero; // PK idAdicionXReservaPasajero

    @ManyToOne
    @JoinColumn(name = "id_adicion", nullable = false)
    private Adicion adicion; // FK idAdicion

    @ManyToOne
    @JoinColumn(name = "id_reserva_pasajero", nullable = false)
    private ReservaPasajero reservaPasajero; // FK idReservaPasajero

    @Column(name = "costo_extra")
    private Double costoExtra; // Costo extra asociado a la adición para esta reserva

    // Constructor
    public AdicionXReservaPasajero() {
    }

    public AdicionXReservaPasajero(Long idAdicionXReservaPasajero, Adicion adicion, ReservaPasajero reservaPasajero, Double costoExtra) {
        this.idAdicionXReservaPasajero = idAdicionXReservaPasajero;
        this.adicion = adicion;
        this.reservaPasajero = reservaPasajero;
        this.costoExtra = costoExtra;
    }

    // Getters y Setters
    public Long getIdAdicionXReservaPasajero() {
        return idAdicionXReservaPasajero;
    }

    public void setIdAdicionXReservaPasajero(Long idAdicionXReservaPasajero) {
        this.idAdicionXReservaPasajero = idAdicionXReservaPasajero;
    }

    public Adicion getAdicion() {
        return adicion;
    }

    public void setAdicion(Adicion adicion) {
        this.adicion = adicion;
    }

    public ReservaPasajero getReservaPasajero() {
        return reservaPasajero;
    }

    public void setReservaPasajero(ReservaPasajero reservaPasajero) {
        this.reservaPasajero = reservaPasajero;
    }

    public Double getCostoExtra() {
        return costoExtra;
    }

    public void setCostoExtra(Double costoExtra) {
        this.costoExtra = costoExtra;
    }

    @Override
    public String toString() {
        return "AdicionXReservaPasajero{" +
                "idAdicionXReservaPasajero=" + idAdicionXReservaPasajero +
                ", adicion=" + adicion +
                ", reservaPasajero=" + reservaPasajero +
                ", costoExtra=" + costoExtra +
                '}';
    }
}
