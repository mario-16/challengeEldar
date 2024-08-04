package com.challegeEldar.challengeEldar;

import com.challegeEldar.challengeEldar.enums.Marca;
import com.challegeEldar.challengeEldar.model.Tarjeta;
import com.challegeEldar.challengeEldar.model.TarjetaResponse;
import com.challegeEldar.challengeEldar.util.TarjetaUtils;

public class Main {

    public static void main(String[] args) throws Exception {

        Tarjeta visa = new Tarjeta(Marca.VISA, "1111", "Pepe", "Jaja", "07/24");
        Tarjeta nara = new Tarjeta(Marca.NARA, "2222", "Ana", "Gomez", "02/25");
        Tarjeta amex = new Tarjeta(Marca.AMEX, "5555", "Luis", "Sosa", "11/25");

        /*System.out.println(visa.informar());
        System.out.println(nara.informar());
        System.out.println(amex.informar());

        System.out.println(visa.esOperacionValida(1500.0));
        System.out.println(visa.esOperacionValida(999.9));

        System.out.println(visa.estaHabilitadaParaOperar());
        System.out.println(amex.estaHabilitadaParaOperar());

        System.out.println(visa.equals(nara));
        System.out.println(visa.equals(new Tarjeta(Marca.VISA, "1111", "AAA", "BBB", "05/24")));*/


        //consultarTasa("visa", 10.0);
        consultarTasa("AMex", 200.9);

    }

    public static void consultarTasa(String marca, double importe) throws Exception {
        try {
            if (!TarjetaUtils.verificarMarcaTarjeta(marca.toLowerCase())){
                throw new Exception("La marca de la tarjeta recibida no es válida");
            }
            if (importe < 0){
                throw new Exception("El importe ingresado es menor a 0");
            }

            TarjetaResponse response = TarjetaUtils.calcularTasa(marca.toLowerCase(), importe);
            System.out.println("La tasa de operacion para la tarjeta " + response.getMarca() + " es: " + response.getTasaOperacion());

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
