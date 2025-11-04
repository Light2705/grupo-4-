package com.elfogon.Services;

import com.elfogon.model.Repartidor;

import java.util.List;

public interface IRepartidorService extends IGenericService<Repartidor, Integer> {

    // Método específico: Buscar un repartidor por su teléfono (único)
    Repartidor findByTelefono(String telefono) throws Exception;

    // Método específico: Encontrar repartidores disponibles para asignar un pedido
    List<Repartidor> findAvailable() throws Exception;
}