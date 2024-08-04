package com.challegeEldar.challengeEldar.service;

import com.challegeEldar.challengeEldar.model.TarjetaRequest;
import com.challegeEldar.challengeEldar.model.TarjetaResponse;
import com.challegeEldar.challengeEldar.util.TarjetaUtils;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService {

    public TarjetaResponse calcularTasaOperacion(TarjetaRequest request) {
        return TarjetaUtils.calcularTasa(request.getMarca().toLowerCase(), request.getImporte());

    }

}
