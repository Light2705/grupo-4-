package com.elfogon.Repository; // Asegúrate de que el paquete sea el correcto

import com.elfogon.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlatoRepository extends  IGenericRepository<Plato, Integer> {

    // Método para buscar platos por su categoría (ej: "Entradas", "Postres")
    List<Plato> findByCategoria(String categoria);

    // Método para encontrar platos que estén actualmente disponibles
    List<Plato> findByDisponibleTrue();

    // Método para buscar platos por nombre, ignorando mayúsculas/minúsculas
    // Útil para búsquedas desde la interfaz de usuario
    List<Plato> findByNombreContainingIgnoreCase(String nombre);

    // Método para buscar platos disponibles por categoría
    List<Plato> findByCategoriaAndDisponibleTrue(String categoria);
}