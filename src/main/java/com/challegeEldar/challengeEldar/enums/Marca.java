package com.challegeEldar.challengeEldar.enums;

public enum Marca {

    VISA("Visa"),
    NARA("Naranja"),
    AMEX("America Express");
    //MASTER("MAster Card");

    private String nombre;

    Marca(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
