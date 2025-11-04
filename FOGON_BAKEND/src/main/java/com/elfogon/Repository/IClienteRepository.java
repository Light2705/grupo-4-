package com.elfogon.Repository;

import com.elfogon.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Si usas una interfaz base IGenericRepo, extiende de ella, sino usa JpaRepository
@Repository
public interface IClienteRepository extends  IGenericRepository<Cliente, Integer> {

    // Opcional: Si necesitas buscar por email
    Cliente findByEmail(String email);

    // Opcional: Si necesitas buscar por número de documento
    Cliente findByNumeroDocumento(String numeroDocumento);

    // Opcional: Si necesitas buscar por nombre o apellido
    List<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
}