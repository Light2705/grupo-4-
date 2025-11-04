package com.elfogon.Repository; // Asegúrate de que el paquete sea el correcto

import com.elfogon.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoRepository extends IGenericRepository<Empleado, Integer> {

    // Método para buscar un empleado por su número de documento, que es único
    Empleado findByNumeroDocumento(String numeroDocumento);

    // Método para encontrar empleados por su rol (por ejemplo, todos los 'Cajeros')
    List<Empleado> findByRol(String rol);

    // Método para buscar empleados cuyo nombre o apellido contenga una cadena
    List<Empleado> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);
}