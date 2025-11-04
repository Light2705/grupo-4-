package com.elfogon.Services.Implementation; // Paquete de implementación

import com.elfogon.model.Cliente;
import com.elfogon.Repository.IClienteRepository; // Necesitamos el repositorio específico
import com.elfogon.Repository.IGenericRepository; // Necesitamos la interfaz base del repositorio (si existe)
import com.elfogon.Services.IClienteService;
import com.elfogon.Services.IGenericService; // Asegúrate de que IGenericService existe en Services
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// Extiende de GenericService<Entidad, ID> e implementa la interfaz de servicio específica
public class ClienteService extends GenericService<Cliente, Integer> implements IClienteService {

    // Inyección de dependencia del repositorio específico para Cliente
    private final IClienteRepository repo;

    // Método requerido para que GenericService sepa qué repositorio usar
    @Override
    protected IGenericRepository<Cliente, Integer> getRepo() {
        return  repo;
    }



    @Override
    public Cliente findByEmail(String email) throws Exception {
        // Usamos el método definido en IClienteRepository
        Cliente cliente = repo.findByEmail(email);


        if (cliente == null) {
            throw new RuntimeException("Cliente con email " + email + " no encontrado.");
        }
        return cliente;
    }

    @Override
    public Cliente findByNumeroDocumento(String numeroDocumento) throws Exception {
        // Usamos el método definido en IClienteRepository
        Cliente cliente = repo.findByNumeroDocumento(numeroDocumento);

        // Opcional: Agregar lógica de manejo de errores
        if (cliente == null) {
            throw new RuntimeException("Cliente con documento " + numeroDocumento + " no encontrado.");
        }
        return cliente;
    }
}