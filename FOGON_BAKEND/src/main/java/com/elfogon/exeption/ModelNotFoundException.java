package com.elfogon.exeption; // Adaptado a tu paquete de excepciones

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada lanzada cuando un registro (Modelo/Entidad)
 * no puede ser encontrado por su ID en la base de datos.
 */
@ResponseStatus(HttpStatus.NOT_FOUND) // Indica que debe responder con un código 404
public class ModelNotFoundException extends RuntimeException{

    // Usamos el serialVersionUID si la clase se va a serializar, aunque es opcional
    // para clases de excepción simples.
    // private static final long serialVersionUID = 1L;

    public ModelNotFoundException(String message) {
        super(message);
    }
}