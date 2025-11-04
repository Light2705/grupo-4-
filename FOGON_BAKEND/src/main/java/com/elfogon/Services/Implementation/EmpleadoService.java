package com.elfogon.Services.Implementation;

import com.elfogon.Repository.IEmpleadoRepository;
import com.elfogon.Repository.IGenericRepository;
import com.elfogon.Services.IEmpleadoService;
import com.elfogon.model.Empleado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService extends GenericService<Empleado, Integer> implements IEmpleadoService {

    private final IEmpleadoRepository repo;

    @Override
    protected IGenericRepository<Empleado, Integer> getRepo() {
        return repo;
    }

    @Override
    public Empleado findByNumeroDocumento(String numeroDocumento) throws Exception {
        return repo.findByNumeroDocumento(numeroDocumento);
    }

    @Override
    public List<Empleado> findByRol(String rol) throws Exception {
        return repo.findByRol(rol);
    }
}
