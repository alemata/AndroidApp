package com.gcba.model;


import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "boliches")
public class Boliche implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer numeroRegistro;
    private String nombre;
    private String domicilioCalle;
    private String domicilioNumbero;    // puede ser con "/", por eso no es String.
    private Integer capacidad;
    private String numeroExpediente;
    private String clase;
    private String estado;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(Integer numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilioCalle() {
        return domicilioCalle;
    }

    public void setDomicilioCalle(String domicilioCalle) {
        this.domicilioCalle = domicilioCalle;
    }

    public String getDomicilioNumbero() {
        return domicilioNumbero;
    }

    public void setDomicilioNumbero(String domicilioNumbero) {
        this.domicilioNumbero = domicilioNumbero;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nombre", getNombre());
        return jsonObject;
//                .element("nombre", getNombre())
//                .element("domicilioCalle", getDomicilioCalle())
//                .element("domicilioNumbero", getDomicilioNumbero())
//                .element("capacidad", getCapacidad())
//                .element("numeroExpediente", getNumeroExpediente())
//                .element("clase", getClase())
//                .element("estado", getEstado());
    }
}
