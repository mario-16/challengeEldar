package com.challegeEldar.challengeEldar.service;

import com.challegeEldar.challengeEldar.model.TarjetaRequest;
import com.challegeEldar.challengeEldar.model.TarjetaResponse;
import com.challegeEldar.challengeEldar.util.TarjetaUtils;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService {

    public TarjetaResponse calcularTasaOperacion(TarjetaRequest request) throws Exception {
        TarjetaResponse response;
        try {
            if (!TarjetaUtils.verificarMarcaTarjeta(request.getMarca())){
                throw new Exception("La marca de la tarjeta recibida no es válida");
            }
            if (request.getImporte() < 0){
                throw new Exception("El importe ingresado es menor a 0");
            }

            response = TarjetaUtils.calcularTasa(request.getMarca().toLowerCase(), request.getImporte());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return response;

    }

}
