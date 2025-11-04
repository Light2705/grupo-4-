package com.elfogon.Services.Implementation;

import com.elfogon.Repository.IPedidoRepository;
import com.elfogon.Repository.IGenericRepository;
import com.elfogon.Services.IPedidoService;
import com.elfogon.model.Cliente;
import com.elfogon.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService extends GenericService<Pedido, Integer> implements IPedidoService {

    private final IPedidoRepository repo;

    @Override
    protected IGenericRepository<Pedido, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Pedido> findByEstado(String estado) throws Exception {
        return repo.findByEstado(estado);
    }

    @Override
    public List<Pedido> findByCliente(Cliente cliente) throws Exception {
        return repo.findByCliente(cliente);
    }

    @Override
    public List<Pedido> findByTipoPedido(String tipoPedido) throws Exception {
        return repo.findByTipoPedido(tipoPedido);
    }
}
