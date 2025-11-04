package com.elfogon.Services.Implementation;

import com.elfogon.Repository.IAsignacionRepartoRepository;
import com.elfogon.Repository.IGenericRepository;
import com.elfogon.Services.IAsignacionRepartoService;
import com.elfogon.model.AsignacionReparto;
import com.elfogon.model.Pedido;
import com.elfogon.model.Repartidor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignacionRepartoService extends GenericService<AsignacionReparto, Integer> implements IAsignacionRepartoService {

    private final IAsignacionRepartoRepository repo;

    @Override
    protected IGenericRepository<AsignacionReparto, Integer> getRepo() {
        return repo;
    }

    @Override
    public AsignacionReparto findByPedido(Pedido pedido) throws Exception {
        return repo.findByPedidoIdPedido(pedido.getIdPedido())
                .orElseThrow(() -> new Exception("No se encontró la asignación para el pedido con ID: " + pedido.getIdPedido()));
    }

    @Override
    public List<AsignacionReparto> findByRepartidor(Repartidor repartidor) throws Exception {
        List<AsignacionReparto> lista = repo.findByRepartidorIdRepartidor(repartidor.getIdRepartidor());
        if (lista.isEmpty()) {
            throw new Exception("No se encontraron asignaciones para el repartidor con ID: " + repartidor.getIdRepartidor());
        }
        return lista;
    }

    @Override
    public List<AsignacionReparto> findByEstado(String estado) throws Exception {
        List<AsignacionReparto> lista = repo.findByEstadoReparto(estado);
        if (lista.isEmpty()) {
            throw new Exception("No se encontraron asignaciones con el estado: " + estado);
        }
        return lista;
    }
}
