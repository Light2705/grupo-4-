package com.elfogon.Services.Implementation;

import com.elfogon.Repository.IRepartidorRepository;
import com.elfogon.Repository.IGenericRepository;
import com.elfogon.Services.IRepartidorService;
import com.elfogon.model.Repartidor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepartidorService extends GenericService<Repartidor, Integer> implements IRepartidorService {

    private final IRepartidorRepository repo;

    @Override
    protected IGenericRepository<Repartidor, Integer> getRepo() {
        return repo;
    }

    @Override
    public Repartidor findByTelefono(String telefono) throws Exception {
        return repo.findByTelefono(telefono);
    }

    @Override
    public List<Repartidor> findAvailable() throws Exception {
        // Se asume que la disponibilidad "Disponible" es el estado para asignación
        return repo.findByDisponibilidad("Disponible");
    }
}
