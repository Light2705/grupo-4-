package com.elfogon.exeption; // Adaptado al paquete de excepciones de tu proyecto

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice // Esta anotación indica que la clase interceptará excepciones lanzadas por los controladores
public class ResponseExceptionHandler {

    // 1. Manejador para la excepción ModelNotFoundException (404)
    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorRecord> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        // Usa el record CustomErrorRecord para estructurar la respuesta
        CustomErrorRecord err = new CustomErrorRecord(
                LocalDateTime.now(),
                ex.getMessage(), // El mensaje que se lanzó en GenericService
                request.getDescription(false) // La URI de la solicitud
        );

        // Retorna el objeto CustomErrorRecord con el código 404 NOT FOUND
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    // 2. Manejador para errores genéricos (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorRecord> handleDefaultExceptions(Exception ex, WebRequest request) {
        CustomErrorRecord err = new CustomErrorRecord(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );

        // Retorna el objeto CustomErrorRecord con el código 500 INTERNAL SERVER ERROR
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 3. Manejador para errores matemáticos específicos (Ej: división por cero, 406 NOT_ACCEPTABLE)
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<CustomErrorRecord> handleArithmeticException(ArithmeticException ex, WebRequest request) {
        CustomErrorRecord err = new CustomErrorRecord(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );

        // Retorna el objeto CustomErrorRecord con el código 406 NOT ACCEPTABLE
        return new ResponseEntity<>(err, HttpStatus.NOT_ACCEPTABLE);
    }
}