package com.challegeEldar.challengeEldar.controller;

import com.challegeEldar.challengeEldar.model.TarjetaRequest;
import com.challegeEldar.challengeEldar.model.TarjetaResponse;
import com.challegeEldar.challengeEldar.service.TarjetaService;
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
    public ResponseEntity<TarjetaResponse> calcularTasa(@RequestBody TarjetaRequest request) throws Exception {
        return new ResponseEntity<>(service.calcularTasaOperacion(request), HttpStatus.OK);
    }

}
