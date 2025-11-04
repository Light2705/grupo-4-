package com.elfogon.Services; // Usando el paquete 'com.elfogon.service'

import com.elfogon.model.Cliente;

public interface IClienteService extends IGenericService<Cliente, Integer> {

    // Método específico: Buscar un cliente por su correo electrónico (único)
    Cliente findByEmail(String email) throws Exception;

    // Método específico: Buscar un cliente por su número de documento (si lo requiere el negocio)
    Cliente findByNumeroDocumento(String numeroDocumento) throws Exception;
}