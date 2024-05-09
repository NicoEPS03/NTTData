package com.nttdata.prueba.service.imp;

import com.nttdata.prueba.entity.Cliente;
import com.nttdata.prueba.exception.ArgumentRequiredException;
import com.nttdata.prueba.exception.ArithmeticException;
import com.nttdata.prueba.exception.IntegridadException;
import com.nttdata.prueba.exception.ModelNotFoundException;
import com.nttdata.prueba.service.IClienteService;
import com.nttdata.prueba.util.DataPrueba;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IClienteServiceImp implements IClienteService {
    @Override
    public Cliente getClient(String documento, String tipoDocumento) throws ArgumentRequiredException, IntegridadException, ModelNotFoundException, ArithmeticException {
        if(documento != null) {
            if (!documento.matches("[0-9]+")){
                throw new ArithmeticException("Documento debe ser númerico");
            }
            if(tipoDocumento != null){
                if(tipoDocumento.equals("C") || tipoDocumento.equals("P")){
                    List<Cliente> clientes = DataPrueba.crearData();
                    Optional<Cliente> clienteEncontrado = clientes.stream()
                            .filter(cliente -> cliente.getDocumento().equals(documento))
                            .findFirst();

                    if (clienteEncontrado.isPresent()) {
                        return clienteEncontrado.get();
                    } else {
                        throw new ModelNotFoundException("Cliente no encontrado");
                    }
                }else {
                    throw new IntegridadException("Tipo de documento no valido");
                }

            }else{
                throw new ArgumentRequiredException("Tipo documento requerido");
            }
        } else {
            throw new ArgumentRequiredException("Documento requerido");
        }
    }
}
