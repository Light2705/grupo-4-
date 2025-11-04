package com.elfogon.Services;

import com.elfogon.model.Ingrediente;
import com.elfogon.model.Proveedor;

import java.util.List;

public interface IIngredienteService extends IGenericService<Ingrediente, Integer> {

    // Método específico: Encontrar ingredientes cuyo stock es bajo (alerta)
    List<Ingrediente> findStockAlert() throws Exception;

    // Método específico: Buscar un ingrediente por nombre, ignorando mayúsculas/minúsculas
    Ingrediente findByNombre(String nombre) throws Exception;

    // Método específico: Encontrar ingredientes por proveedor principal
    List<Ingrediente> findByProveedor(Proveedor proveedor) throws Exception;
}