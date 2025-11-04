package com.elfogon.Services.Implementation;

import com.elfogon.Repository.IProveedorRepository;
import com.elfogon.Repository.IGenericRepository;
import com.elfogon.Services.IProveedorService;
import com.elfogon.model.Proveedor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProveedorService extends GenericService<Proveedor, Integer> implements IProveedorService {

    private final IProveedorRepository repo;

    @Override
    protected IGenericRepository<Proveedor, Integer> getRepo() {
        return repo;
    }

    @Override
    public Proveedor findByRuc(String ruc) throws Exception {
        return repo.findByRuc(ruc);
    }

    @Override
    public Proveedor findByNombre(String nombre) throws Exception {
        return repo.findByNombreIgnoreCase(nombre);
    }
}
