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
        try {
            YearMonth mesAnio = YearMonth.parse(fechaVencimiento, formatter);
            LocalDate fechaCaducidad = mesAnio.atEndOfMonth();
            estaHabilitada = diaActual.isBefore(fechaCaducidad);
            System.out.println(fechaCaducidad);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return estaHabilitada;
    }


    public int compararTarjetas(Tarjeta tarjeta){
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarjeta tarjeta = (Tarjeta) o;
        return marca == tarjeta.marca && nroTarjeta.equals(tarjeta.nroTarjeta);
    }

    public void informarTasa(String marca, int importe) throws Exception {
        LocalDate diaActual = LocalDate.now();
        switch (marca) {
            case "VISA":
                String[] fechaPartida = fechaVencimiento.split("/");
                System.out.println(importe * (Integer.parseInt(fechaPartida[1]) / Integer.parseInt(fechaPartida[0])));
                break;
            case "NARA":
                int dayOfMonth = diaActual.getDayOfMonth();
                System.out.println(importe * (dayOfMonth * 0.5));
                break;
            case "AMEX":
                System.out.println(importe * (diaActual.getMonthValue() * 0.1));
                break;
//            default:
//                System.out.println("La marca enviada no existe");
        }

    }



}
