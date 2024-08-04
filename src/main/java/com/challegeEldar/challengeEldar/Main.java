package com.challegeEldar.challengeEldar;

import com.challegeEldar.challengeEldar.enums.Marca;
import com.challegeEldar.challengeEldar.model.Tarjeta;
import com.challegeEldar.challengeEldar.util.TarjetaUtils;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {

        Tarjeta visa = new Tarjeta(Marca.VISA, "1111", "Pepe", "Jaja", "07/24");
        Tarjeta nara = new Tarjeta(Marca.NARA, "2222", "Ana", "Gomez", "02/25");
        Tarjeta amex = new Tarjeta(Marca.AMEX, "3333", "Luis", "Sosa", "11/25");
        System.out.println(visa.informar());
        System.out.println(visa.esOperacionValida(1500.0));
        System.out.println(visa.estaHabilitadaParaOperar());
//        System.out.println(visa.equals(new Tarjeta(Marca.VISA, "1111", "AAA", "BBB", "05/24", 2)));
        consultarTasa("visa", 10);

    }

    public static void consultarTasa(String marca, int importe) throws Exception {
        try {
            if (!TarjetaUtils.verificarMarcaTarjeta(marca)){
                throw new Exception("La marca de la tarjeta recibida no es válida");
            }
            if (importe < 0){
                throw new Exception("El importe ingresado es menor a 0");
            }

            switch (marca.toLowerCase()) {
                case "visa":
                    informarTasaVisa(importe);
                    break;
                case "nara":
                    informarTasaNara(importe);
                    break;
                case "amex":
                    informarTasaAmex(importe);
                    break;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static void informarTasaAmex(int importe) {
        LocalDate diaActual = LocalDate.now();
        int dayOfMonth = diaActual.getDayOfMonth();
        System.out.println(importe * (dayOfMonth * 0.5));
    }

    private static void informarTasaNara(int importe) {
        LocalDate diaActual = LocalDate.now();
        System.out.println(importe * (diaActual.getMonthValue() * 0.1));
    }

    private static void informarTasaVisa(int importe) {
        LocalDate diaActual = LocalDate.now();
        //String[] fechaPartida = getFechaVencimiento().split("/");
        System.out.println(importe * (diaActual.getYear() / diaActual.getMonthValue()));
    }

}
