package com.elfogon.exeption; // Adaptado al paquete de excepciones de tu proyecto

import java.time.LocalDateTime;

/**
 * Record para estructurar la respuesta de error de la API.
 * Proporciona una vista consistente de los errores al cliente.
 */
public record CustomErrorRecord(
        // Momento en que ocurrió el error
        LocalDateTime datetime,

        // Mensaje principal del error (ej: "Recurso no encontrado")
        String message,

        // Detalles específicos (ej: URI de la solicitud, excepción exacta)
        String details
) {
    // Los records de Java 16+ generan automáticamente el constructor,
    // getters, hashCode, equals y toString.
}