package com.elfogon.Services.Implementation;

import com.elfogon.Repository.IDetallePedidoRepository;
import com.elfogon.Repository.IGenericRepository;
import com.elfogon.Services.IDetallePedidoService;
import com.elfogon.model.DetallePedido;
import com.elfogon.model.Pedido;
import com.elfogon.model.Plato;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetallePedidoService extends GenericService<DetallePedido, Integer> implements IDetallePedidoService {

    private final IDetallePedidoRepository repo;

    @Override
    protected IGenericRepository<DetallePedido, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<DetallePedido> findByPedido(Pedido pedido) throws Exception {
        return repo.findByPedido(pedido);
    }

    @Override
    public List<DetallePedido> findByPlato(Plato plato) throws Exception {
        return repo.findByPlato(plato);
    }
}
