package com.nttdata.prueba.util;

import com.nttdata.prueba.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class DataPrueba {
    public static List<Cliente> crearData() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add( new Cliente("C", "23445322", "Juan", "Luis",
                "González", "Rodríguez", "978312312", "calle punto a #12a12", "Madrid"));
        clientes.add(new Cliente("C", "124124124", "Pedro", "Sergio",
                "Martínez", "Pérez", "654321987", "Avenida Central 456", "Barcelona"));
        clientes.add(new Cliente("P", "14124124", "Juan", "Carlos",
                "Fernández", "González", "789456123", "Calle Secundaria 789", "Valencia"));
        return clientes;
    }
}
