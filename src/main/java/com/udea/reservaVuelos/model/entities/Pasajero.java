package com.udea.reservaVuelos.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pasajero")
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pasajero")
    private Long idPasajero; // PK idPasajero

    @Column(name = "nombre", nullable = false)
    private String nombre; // nombre

    @Column(name = "apellido", nullable = false)
    private String apellido; // apellido

    @Column(name = "tipo_documento", nullable = false)
    private String tipoDocumento; // tipo documento

    @Column(name = "numero_documento", nullable = false, unique = true)
    private String numeroDocumento; // numero de documento

    @Column(name = "correo", nullable = false, unique = true)
    private String correo; // correo

    @Column(name = "telefono")
    private String telefono; // telefono

    // Constructor
    public Pasajero() {
    }

    public Pasajero(Long idPasajero, String nombre, String apellido, String tipoDocumento, String numeroDocumento, String correo, String telefono) {
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y Setters
    public Long getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Long idPasajero) {
        this.idPasajero = idPasajero;
    }

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

}
