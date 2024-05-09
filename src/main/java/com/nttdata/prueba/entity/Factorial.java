package com.nttdata.prueba.entity;

public class Factorial {
    private int numero;
    private long factorial;

    public Factorial(int numero, long factorial) {
        this.numero = numero;
        this.factorial = factorial;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getFactorial() {
        return factorial;
    }

    public void setFactorial(long factorial) {
        this.factorial = factorial;
    }
}
