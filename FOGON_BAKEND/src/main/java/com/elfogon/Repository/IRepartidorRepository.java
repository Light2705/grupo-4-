package com.elfogon.Repository; // Asegúrate de que el paquete sea el correcto

import com.elfogon.model.Repartidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepartidorRepository extends IGenericRepository<Repartidor, Integer> {

    // Método para buscar un repartidor por su número de teléfono, que es único
    Repartidor findByTelefono(String telefono);

    // Método para encontrar repartidores según su disponibilidad
    // (Ej: "Disponible", "En Entrega", "Fuera de Servicio")
    List<Repartidor> findByDisponibilidad(String disponibilidad);

    // Método para buscar repartidores por nombre o apellido
    List<Repartidor> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);
}