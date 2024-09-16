package com.udea.reservaVuelos.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "accesibilidad")
public class Accesibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_accesibilidad")
    private Long idAccesibilidad; // PK idAccesibilidad

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre; // nombre

    // Constructor
    public Accesibilidad() {
    }

    public Accesibilidad(Long idAccesibilidad, String nombre) {
        this.idAccesibilidad = idAccesibilidad;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getIdAccesibilidad() {
        return idAccesibilidad;
    }

    public void setIdAccesibilidad(Long idAccesibilidad) {
        this.idAccesibilidad = idAccesibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Accesibilidad{" +
                "idAccesibilidad=" + idAccesibilidad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
