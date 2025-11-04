package com.elfogon.Services.Implementation;

import com.elfogon.Repository.IPlatoRepository;
import com.elfogon.Repository.IGenericRepository;
import com.elfogon.Services.IPlatoService;
import com.elfogon.model.Plato;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlatoService extends GenericService<Plato, Integer> implements IPlatoService {

    private final IPlatoRepository repo;

    @Override
    protected IGenericRepository<Plato, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Plato> findAvailable() throws Exception {
        return repo.findByDisponibleTrue();
    }

    @Override
    public List<Plato> findByCategoria(String categoria) throws Exception {
        return repo.findByCategoria(categoria);
    }
}
