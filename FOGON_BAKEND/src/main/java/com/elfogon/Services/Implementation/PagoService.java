package com.elfogon.Services.Implementation;

import com.elfogon.Repository.IPagoRepository;
import com.elfogon.Repository.IGenericRepository;
import com.elfogon.Services.IPagoService;
import com.elfogon.model.Pago;
import com.elfogon.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagoService extends GenericService<Pago, Integer> implements IPagoService {

    private final IPagoRepository repo;

    @Override
    protected IGenericRepository<Pago, Integer> getRepo() {
        return repo;
    }

    @Override
    public Pago findByPedido(Pedido pedido) throws Exception {
        return repo.findByPedido(pedido);
    }

    @Override
    public List<Pago> findByMetodoPago(String metodoPago) throws Exception {
        return repo.findByMetodoPago(metodoPago);
    }

    @Override
    public List<Pago> findByEstadoTransaccion(String estado) throws Exception {
        return repo.findByEstadoTransaccion(estado);
    }
}
