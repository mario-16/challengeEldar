package com.challegeEldar.challengeEldar.model;

import com.challegeEldar.challengeEldar.enums.Marca;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Tarjeta {

    private Marca marca;
    private String nroTarjeta;
    private String nombre;
    private String apellido;
    private String fechaVencimiento;

    public Tarjeta(Marca marca, String nroTarjeta, String nombre, String apellido, String fechaVencimiento) {
        this.marca = marca;
        this.nroTarjeta = nroTarjeta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
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

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String informar(){
        String nombreMarca = "Marca: " + marca;
        String numeroTarjeta = " Nro tarjeta: " + nroTarjeta;
        String cardHolder = " Nombre y apellido: " + nombre + " " + apellido;
        String fechaVenc = " Fecha de vencimiento: " + fechaVencimiento;
        return  nombreMarca + numeroTarjeta + cardHolder + fechaVenc;
    }

    public boolean esOperacionValida(double importe) {
        return importe < 1000;
    }

    public boolean estaHabilitadaParaOperar(){
        LocalDate diaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        boolean estaHabilitada = false;
        //try {
            YearMonth mesAnio = YearMonth.parse(fechaVencimiento, formatter);
            LocalDate fechaCaducidad = mesAnio.atEndOfMonth();
            estaHabilitada = diaActual.isBefore(fechaCaducidad);
            System.out.println(fechaCaducidad);

        /*} catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        return estaHabilitada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarjeta tarjeta = (Tarjeta) o;
        return marca == tarjeta.marca && nroTarjeta.equals(tarjeta.nroTarjeta);
    }

}
