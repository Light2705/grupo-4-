package com.elfogon.Services.Implementation;

import com.elfogon.Repository.IIngredienteRepository;
import com.elfogon.Repository.IGenericRepository;
import com.elfogon.Services.IIngredienteService;
import com.elfogon.model.Ingrediente;
import com.elfogon.model.Proveedor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredienteService extends GenericService<Ingrediente, Integer> implements IIngredienteService {

    private final IIngredienteRepository repo;

    @Override
    protected IGenericRepository<Ingrediente, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Ingrediente> findStockAlert() throws Exception {
        // Devuelve ingredientes cuyo stock actual es menor o igual al mínimo
        return repo.findByStockActualLessThanEqual(0.0);
    }

    @Override
    public Ingrediente findByNombre(String nombre) throws Exception {
        return repo.findByNombreIgnoreCase(nombre);
    }

    @Override
    public List<Ingrediente> findByProveedor(Proveedor proveedor) throws Exception {
        return repo.findByProveedorPrincipal(proveedor);
    }
}
