package com.elfogon.Services;

import com.elfogon.model.Plato;

import java.util.List;

public interface IPlatoService extends IGenericService<Plato, Integer> {

    // Método específico: Encontrar platos disponibles
    List<Plato> findAvailable() throws Exception;

    // Método específico: Encontrar platos por su categoría
    List<Plato> findByCategoria(String categoria) throws Exception;
}