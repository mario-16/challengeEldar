package com.challegeEldar.challengeEldar.service;

import com.challegeEldar.challengeEldar.enums.Marca;
import com.challegeEldar.challengeEldar.model.TarjetaRequest;
import com.challegeEldar.challengeEldar.model.TarjetaResponse;
import com.challegeEldar.challengeEldar.util.TarjetaUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TarjetaService {

    public TarjetaResponse calcularTasaOperacion(TarjetaRequest request) throws Exception {
        /*double tasaServicio = (double) (25 / 07);
        double tasaOperacion = request.getImporte() * tasaServicio;
        return new TarjetaResponse(request.getMarca(), request.getImporte(), tasaServicio, tasaOperacion);*/

        TarjetaResponse response = null;
        try {
            if (!TarjetaUtils.verificarMarcaTarjeta(request.getMarca())){
                throw new Exception("La marca de la tarjeta recibida no es válida");
            }
            if (request.getImporte() < 0){
                throw new Exception("El importe ingresado es menor a 0");
            }

            switch (request.getMarca().toLowerCase()) {
                case "visa":
                    response = informarTasaVisa(request);
                    break;
                case "nara":
                    response = informarTasaNara(request);
                    break;
                case "amex":
                    response = informarTasaAmex(request);
                    break;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return response;

    }

    private static TarjetaResponse informarTasaVisa(TarjetaRequest request) {
        /*LocalDate diaActual = LocalDate.now();
        String[] fechaPartida = getFechaVencimiento().split("/");
        System.out.println(importe * (diaActual.getYear() / diaActual.getMonthValue()));*/

        double tasaServicio = (double) (25 / 07);
        double tasaOperacion = request.getImporte() * tasaServicio;
        System.out.println(tasaOperacion);
        return new TarjetaResponse(request.getMarca(), request.getImporte(), tasaServicio, tasaOperacion);

    }

    private static TarjetaResponse informarTasaNara(TarjetaRequest request) {
        LocalDate diaActual = LocalDate.now();
        double tasaServicio = diaActual.getMonthValue() * 0.1;
        double tasaOperacion = request.getImporte() * tasaServicio;
        System.out.println(tasaOperacion);
        return new TarjetaResponse(request.getMarca(), request.getImporte(), tasaServicio, tasaOperacion);
    }

    private static TarjetaResponse informarTasaAmex(TarjetaRequest request) {
        LocalDate diaActual = LocalDate.now();
        int dayOfMonth = diaActual.getDayOfMonth();
        double tasaServicio = dayOfMonth * 0.5;
        double tasaOperacion = request.getImporte() * tasaServicio;
        System.out.println(tasaOperacion);
        return new TarjetaResponse(request.getMarca(), request.getImporte(), tasaServicio, tasaOperacion);
    }
}
