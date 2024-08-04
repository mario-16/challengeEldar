package com.challegeEldar.challengeEldar.model;

public class TarjetaResponse {

    private String marca;
    private double importe;
    private double tasaServicio;
    private double tasaOperacion;

    public TarjetaResponse(String marca, double importe, double tasaServicio, double tasaOperacion) {
        this.marca = marca;
        this.importe = importe;
        this.tasaServicio = tasaServicio;
        this.tasaOperacion = tasaOperacion;
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

    public double getTasaServicio() {
        return tasaServicio;
    }

    public void setTasaServicio(double tasaServicio) {
        this.tasaServicio = tasaServicio;
    }

    public double getTasaOperacion() {
        return tasaOperacion;
    }

    public void setTasaOperacion(double tasaOperacion) {
        this.tasaOperacion = tasaOperacion;
    }
}
