package com.nttdata.prueba.controller;

import com.nttdata.prueba.entity.Cliente;
import com.nttdata.prueba.exception.ArgumentRequiredException;
import com.nttdata.prueba.exception.ArithmeticException;
import com.nttdata.prueba.exception.IntegridadException;
import com.nttdata.prueba.exception.ModelNotFoundException;
import com.nttdata.prueba.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private IClienteService service;

    @GetMapping(value = "obtener/{tipoDocumento}/{documento}", produces = "application/json")
    public ResponseEntity<?> retornarCliente(@PathVariable("tipoDocumento") String tipoDocumento, @PathVariable("documento") String documento ) throws IntegridadException, ArithmeticException, ArgumentRequiredException, ModelNotFoundException {
        Cliente cliente = service.getClient(documento, tipoDocumento);

        return new ResponseEntity<Object>(cliente, HttpStatus.OK);
    }
}
