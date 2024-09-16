package com.udea.reservaVuelos.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "adicion")
public class Adicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adicion")
    private Long idAtributo; // PK idAtributo

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre; // nombre

    @Column(name = "costo_extra")
    private Double costoExtra; // costoExtra

    // Constructor
    public Adicion() {
    }

    public Adicion(Long idAtributo, String nombre, Double costoExtra) {
        this.idAtributo = idAtributo;
        this.nombre = nombre;
        this.costoExtra = costoExtra;
    }

    // Getters y Setters
    public Long getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(Long idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCostoExtra() {
        return costoExtra;
    }

    public void setCostoExtra(Double costoExtra) {
        this.costoExtra = costoExtra;
    }

    @Override
    public String toString() {
        return "Adicion{" +
                "idAtributo=" + idAtributo +
                ", nombre='" + nombre + '\'' +
                ", costoExtra=" + costoExtra +
                '}';
    }
}
