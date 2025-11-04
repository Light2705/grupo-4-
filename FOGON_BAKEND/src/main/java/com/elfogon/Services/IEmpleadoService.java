package com.elfogon.Services;

import com.elfogon.model.Empleado;

import java.util.List;

public interface IEmpleadoService extends IGenericService<Empleado, Integer> {

    // Método específico: Buscar un empleado por su número de documento (único)
    Empleado findByNumeroDocumento(String numeroDocumento) throws Exception;

    // Método específico: Encontrar empleados por su rol (Ej: "Cocinero", "Cajero")
    List<Empleado> findByRol(String rol) throws Exception;
}