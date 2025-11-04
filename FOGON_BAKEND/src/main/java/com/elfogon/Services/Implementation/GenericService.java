package com.elfogon.Services.Implementation; // Usamos 'implementation' para el paquete

import com.elfogon.exeption.ModelNotFoundException; // Asegúrate de que esta clase exista en tu proyecto
import com.elfogon.Repository.IGenericRepository; // Interfaz genérica del repositorio (asumida)
import com.elfogon.Services.IGenericService;

import java.util.List;


public abstract class GenericService<T, ID> implements IGenericService<T, ID> {

    // Método abstracto para que cada servicio concreto inyecte su repositorio específico
    protected abstract IGenericRepository<T, ID> getRepo();

    // --- Implementación de IGenericService ---

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        // Validación: Verifica que la entidad a actualizar exista antes de guardar.
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO ENCONTRADO: " + id));

        // Se asume que el objeto 't' contiene el ID para que Spring Data JPA realice la operación de actualización (UPDATE).
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        // Devuelve la entidad o lanza una excepción si no se encuentra.
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO ENCONTRADO: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        // Validación: Verifica que la entidad a eliminar exista.
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO ENCONTRADO: " + id));
        getRepo().deleteById(id);
    }
}