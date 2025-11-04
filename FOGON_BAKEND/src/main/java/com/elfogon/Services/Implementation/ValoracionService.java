package com.elfogon.Services.Implementation;

import com.elfogon.Repository.IValoracionRepository;
import com.elfogon.Repository.IGenericRepository;
import com.elfogon.Services.IValoracionService;
import com.elfogon.model.Pedido;
import com.elfogon.model.Valoracion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValoracionService extends GenericService<Valoracion, Integer> implements IValoracionService {

    private final IValoracionRepository repo;

    @Override
    protected IGenericRepository<Valoracion, Integer> getRepo() {
        return repo;
    }

    @Override
    public Valoracion findByPedido(Pedido pedido) throws Exception {
        return repo.findByPedido(pedido);
    }

    @Override
    public List<Valoracion> findByMinRating(Integer calificacionMinima) throws Exception {
        return repo.findByCalificacionGreaterThanEqual(calificacionMinima);
    }
}
