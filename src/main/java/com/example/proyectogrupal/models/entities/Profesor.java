package com.example.proyectogrupal.models.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "profesor")
public class Profesor implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

    @Column(name = "nombre_profesor")
    private String nombre_profesor;

    @Column(name = "apellido_profesor")
    private String apellido_profesor;

    @Column(name = "email")
    private String email;

    @Column(name = "nombre_instituto")
    private String nombre_instituto;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "poblacion")
    private String poblacion;

    @Column(name = "cod_postal")
    private String cod_postal;

    @Column(name = "fase")
    private int fase;

  //Constructor
    public Profesor(Long idProfesor, String nombre_profesor, String apellido_profesor, String email,
                    String nombre_instituto, String direccion, String poblacion, String cod_postal, int fase) {
        this.idProfesor = idProfesor;

        this.nombre_profesor = nombre_profesor;
        this.apellido_profesor = apellido_profesor;
        this.email = email;
        this.nombre_instituto = nombre_instituto;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.cod_postal = cod_postal;
        this.fase = fase;
    }

    public Profesor() {

    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }


    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public String getApellido_profesor() {
        return apellido_profesor;
    }

    public void setApellido_profesor(String apellido_profesor) {
        this.apellido_profesor = apellido_profesor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre_instituto() {
        return nombre_instituto;
    }

    public void setNombre_instituto(String nombre_instituto) {
        this.nombre_instituto = nombre_instituto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }
}
