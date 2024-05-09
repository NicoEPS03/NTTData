package com.nttdata.prueba.service;

import com.nttdata.prueba.entity.Cliente;
import com.nttdata.prueba.exception.ArgumentRequiredException;
import com.nttdata.prueba.exception.ArithmeticException;
import com.nttdata.prueba.exception.IntegridadException;
import com.nttdata.prueba.exception.ModelNotFoundException;

public interface IClienteService {
    public Cliente getClient(String documento, String tipoDocumento) throws ArgumentRequiredException, IntegridadException, ModelNotFoundException, ArithmeticException;
}
