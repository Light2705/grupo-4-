package com.elfogon.Services; // Adaptado al paquete 'com.elfogon'

import java.util.List;

public interface IGenericService<T, ID> {

    /**
     * Guarda una entidad o actualiza si ya existe (uso común en Spring Data JPA).
     * @param t Entidad a guardar.
     * @return La entidad guardada con su ID si es nueva.
     * @throws Exception Si ocurre un error durante la persistencia.
     */
    T save(T t) throws Exception;

    /**
     * Actualiza una entidad existente.
     * @param t Entidad con los datos actualizados.
     * @param id Clave primaria de la entidad a actualizar.
     * @return La entidad actualizada.
     * @throws Exception Si no se encuentra la entidad o ocurre un error.
     */
    T update(T t, ID id) throws Exception;

    /**
     * Recupera todas las entidades del tipo T.
     * @return Una lista de todas las entidades.
     * @throws Exception Si ocurre un error durante la consulta.
     */
    List<T> findAll() throws Exception;

    /**
     * Recupera una entidad por su clave primaria.
     * @param id Clave primaria de la entidad.
     * @return La entidad encontrada.
     * @throws Exception Si no se encuentra la entidad o ocurre un error.
     */
    T findById(ID id) throws Exception;

    /**
     * Elimina una entidad por su clave primaria.
     * @param id Clave primaria de la entidad a eliminar.
     * @throws Exception Si no se encuentra la entidad o ocurre un error.
     */
    void delete(ID id) throws Exception;
}