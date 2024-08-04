package com.challegeEldar.challengeEldar.model;

public class TarjetaRequest {

    private String marca;
    private double importe;

    public TarjetaRequest(String marca, double importe) {
        this.marca = marca;
        this.importe = importe;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

}
