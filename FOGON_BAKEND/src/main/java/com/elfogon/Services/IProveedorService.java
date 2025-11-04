package com.elfogon.Services;

import com.elfogon.model.Proveedor;

public interface IProveedorService extends IGenericService<Proveedor, Integer> {

    // Método específico: Buscar un proveedor por su RUC (único)
    Proveedor findByRuc(String ruc) throws Exception;

    // Método específico: Buscar un proveedor por nombre, ignorando mayúsculas/minúsculas
    Proveedor findByNombre(String nombre) throws Exception;
}