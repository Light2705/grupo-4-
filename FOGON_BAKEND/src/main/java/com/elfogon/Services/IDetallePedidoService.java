package com.elfogon.Services;

import com.elfogon.model.DetallePedido;
import com.elfogon.model.Pedido;
import com.elfogon.model.Plato;

import java.util.List;

public interface IDetallePedidoService extends IGenericService<DetallePedido, Integer> {

    // Método específico: Obtener todos los detalles de un pedido
    List<DetallePedido> findByPedido(Pedido pedido) throws Exception;

    // Método específico: Obtener todos los detalles que contienen un plato específico
    List<DetallePedido> findByPlato(Plato plato) throws Exception;
}