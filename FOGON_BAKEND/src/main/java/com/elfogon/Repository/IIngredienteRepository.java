package com.elfogon.Repository; // Asegúrate de que el paquete sea el correcto

import com.elfogon.model.Ingrediente;
import com.elfogon.model.Proveedor; // Importamos Proveedor para la búsqueda
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIngredienteRepository extends  IGenericRepository<Ingrediente, Integer> {

    // Método para buscar ingredientes por nombre (ignorando mayúsculas/minúsculas)
    Ingrediente findByNombreIgnoreCase(String nombre);

    // Método para encontrar ingredientes cuyo stock actual es menor al stock mínimo
    // Esto es crucial para generar alertas de reabastecimiento
    List<Ingrediente> findByStockActualLessThan(Double stockMinimo);

    // Método para encontrar ingredientes cuyo stock actual es menor o igual al stock mínimo
    List<Ingrediente> findByStockActualLessThanEqual(Double stockMinimo);

    // Método para encontrar ingredientes suministrados por un proveedor específico
    List<Ingrediente> findByProveedorPrincipal(Proveedor proveedorPrincipal);
}