package com.elfogon.Services;

import com.elfogon.model.AsignacionReparto;
import com.elfogon.model.Pedido;
import com.elfogon.model.Repartidor;

import java.util.List;

public interface IAsignacionRepartoService extends IGenericService<AsignacionReparto, Integer> {

    // Método específico: Obtener la asignación de un pedido (único)
    AsignacionReparto findByPedido(Pedido pedido) throws Exception;

    // Método específico: Encontrar asignaciones por repartidor
    List<AsignacionReparto> findByRepartidor(Repartidor repartidor) throws Exception;

    // Método específico: Encontrar asignaciones por estado (Ej: "En Camino")
    List<AsignacionReparto> findByEstado(String estado) throws Exception;
}