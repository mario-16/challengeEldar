package com.challegeEldar.challengeEldar;

public class Ejercicio5 {

    public static void main(String[] args) throws Exception {

        String[] miArray = {"FirstW0rd", "SecondWord", "THIRDWORD", "qwe", "asd", "zxc", "wer", "sdf", "xcv", "rty", "fgh"};
        try {
            System.out.println(unirPalabras(miArray));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static String unirPalabras(String[] palabras) throws Exception {
        if (palabras.length > 10) {
            throw new Exception("La longitud del array supera los 10 elementos");
        }
        StringBuilder builder = new StringBuilder();
        for(String word : palabras) {
            if (word.matches("[A-Za-z]+")) {
                builder.append(word.toLowerCase()).append(" ");
            }
        }
        return builder.toString().trim();
    }
}
