package com.nttdata.prueba.controller;

import com.nttdata.prueba.entity.Factorial;
import com.nttdata.prueba.entity.Saludo;
import com.nttdata.prueba.service.imp.GeneralServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GeneralController {
    @Autowired
    private GeneralServiceImp service;

    @GetMapping(value = "hola/{equipo}", produces = "application/json")
    public Saludo obtenerSaludo(@PathVariable("equipo") String equipo) {
        return new Saludo("¡Hola desde " + equipo + "!");
    }

    @GetMapping(value = "factorial/{numero}", produces = "application/json")
    public Factorial calcularFactorial(@PathVariable("numero") int numero) {
        long factorial = service.calcularFactorial(numero);
        return new Factorial(numero, factorial);
    }

}
