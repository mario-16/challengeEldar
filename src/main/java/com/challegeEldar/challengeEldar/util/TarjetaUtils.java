package com.challegeEldar.challengeEldar.util;

import com.challegeEldar.challengeEldar.enums.Marca;

public class TarjetaUtils {

    public static boolean verificarMarcaTarjeta(String marca) {
        boolean nombreValido = false;
        for (int m = 0; m < Marca.values().length; m++) {
            if (Marca.values()[m].getNombre().equalsIgnoreCase(marca)) {
                nombreValido = true;
                break;
            }
        }
        return nombreValido;
    }

}
