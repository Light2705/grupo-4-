package com.elfogon.Services;

import com.elfogon.model.Pago;
import com.elfogon.model.Pedido;

import java.util.List;

public interface IPagoService extends IGenericService<Pago, Integer> {

    // Método específico: Obtener el pago de un pedido (único)
    Pago findByPedido(Pedido pedido) throws Exception;

    // Método específico: Encontrar pagos por método (Ej: "Tarjeta", "Efectivo")
    List<Pago> findByMetodoPago(String metodoPago) throws Exception;

    // Método específico: Encontrar pagos por estado de transacción (Ej: "Completado")
    List<Pago> findByEstadoTransaccion(String estado) throws Exception;
}