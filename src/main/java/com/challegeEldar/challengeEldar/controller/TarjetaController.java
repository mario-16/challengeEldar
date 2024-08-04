package com.challegeEldar.challengeEldar.controller;

import com.challegeEldar.challengeEldar.exceptions.BadRequestException;
import com.challegeEldar.challengeEldar.exceptions.NotFoundException;
import com.challegeEldar.challengeEldar.model.TarjetaRequest;
import com.challegeEldar.challengeEldar.model.TarjetaResponse;
import com.challegeEldar.challengeEldar.service.TarjetaService;
import com.challegeEldar.challengeEldar.util.TarjetaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarjetaController {

    @Autowired
    private TarjetaService service;

    @GetMapping("/calcularTasa")
    public ResponseEntity<TarjetaResponse> calcularTasa(@RequestBody TarjetaRequest request) {
        if (request.getMarca() == null || request.getMarca().isEmpty()){
            throw new BadRequestException("El campo 'marca' es nulo o esta vacio");
        }
        if (request.getImporte() <= 0){
            throw new BadRequestException("El campo 'importe' es menor o igual a 0");
        }
        if (!TarjetaUtils.verificarMarcaTarjeta(request.getMarca().toLowerCase())){
            throw new NotFoundException("La marca de la tarjeta recibida no es válida");
        }

        return new ResponseEntity<>(service.calcularTasaOperacion(request), HttpStatus.OK);
    }

}
