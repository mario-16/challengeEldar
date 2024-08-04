package com.challegeEldar.challengeEldar.util;

import com.challegeEldar.challengeEldar.enums.Marca;
import com.challegeEldar.challengeEldar.model.TarjetaResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TarjetaUtils {

    public static final LocalDate diaActual = LocalDate.now();

    public static boolean verificarMarcaTarjeta(String marca) {
        boolean nombreValido = false;
        for (int m = 0; m < Marca.values().length; m++) {
            if (Marca.values()[m].name().equalsIgnoreCase(marca)) {
                nombreValido = true;
                break;
            }
        }
        return nombreValido;
    }

    public static TarjetaResponse calcularTasa(String marca, double importe) {
        TarjetaResponse response = null;
        switch (marca.toLowerCase()) {
            case "visa":
                response = informarTasaVisa(importe);
                break;
            case "nara":
                response = informarTasaNara(importe);
                break;
            case "amex":
                response = informarTasaAmex(importe);
                break;
        }
        return response;
    }

    private static TarjetaResponse informarTasaVisa(double importe) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        String anio = diaActual.format(formatter);
        double tasaVisa = (double) Integer.parseInt(anio) / diaActual.getMonthValue();
        double tasaOperacion = importe * tasaVisa;
        System.out.println(tasaOperacion);
        return new TarjetaResponse(Marca.VISA.getNombre(), importe, tasaVisa, tasaOperacion);
    }

    private static TarjetaResponse informarTasaNara(double importe) {
        double tasaNara = diaActual.getMonthValue() * 0.1;
        double tasaOperacion = importe * tasaNara;
        System.out.println(tasaOperacion);
        return new TarjetaResponse(Marca.NARA.getNombre(), importe, tasaNara, tasaOperacion);
    }

    private static TarjetaResponse informarTasaAmex(double importe) {
        int diaDelMes = diaActual.getDayOfMonth();
        double tasaAmex = diaDelMes * 0.5;
        double tasaOperacion = importe * tasaAmex;
        System.out.println(tasaOperacion);
        return new TarjetaResponse(Marca.AMEX.getNombre(), importe, tasaAmex, tasaOperacion);
    }

}
