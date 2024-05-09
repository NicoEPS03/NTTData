package com.nttdata.prueba.service.imp;

import org.springframework.stereotype.Service;

@Service
public class GeneralServiceImp {
    public long calcularFactorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número debe ser mayor o igual a cero");
        }
        long factorial = 1;
        for (int i = 2; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
