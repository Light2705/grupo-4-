package com.elfogon.Services;

import com.elfogon.model.Pedido;
import com.elfogon.model.Cliente;

import java.util.List;

public interface IPedidoService extends IGenericService<Pedido, Integer> {

    // Método específico: Encontrar pedidos por su estado (Ej: "Pendiente", "Entregado")
    List<Pedido> findByEstado(String estado) throws Exception;

    // Método específico: Encontrar todos los pedidos de un cliente
    List<Pedido> findByCliente(Cliente cliente) throws Exception;

    // Método específico: Encontrar pedidos por tipo (Ej: "Domicilio")
    List<Pedido> findByTipoPedido(String tipoPedido) throws Exception;
}