package com.elfogon.Repository; // Asegúrate de que el paquete sea el correcto

import com.elfogon.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProveedorRepository extends  IGenericRepository<Proveedor, Integer> {

    // Método para buscar un proveedor por su RUC (Registro Único de Contribuyentes), que es único
    Proveedor findByRuc(String ruc);

    // Método para buscar un proveedor por su nombre completo, ignorando mayúsculas/minúsculas
    Proveedor findByNombreIgnoreCase(String nombre);

    // Método para buscar proveedores cuyo nombre contenga una cadena (búsqueda parcial)
    List<Proveedor> findByNombreContainingIgnoreCase(String nombre);
}