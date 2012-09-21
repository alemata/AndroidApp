package com.example.model;


public class Boliche {


    private String name;
    private String description;
    private String direccion;

    public Boliche(String name, String description, String direccion) {
        this.name = name;
        this.description = description;
        this.direccion = direccion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
