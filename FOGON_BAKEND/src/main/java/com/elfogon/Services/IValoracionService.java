package com.elfogon.Services;

import com.elfogon.model.Valoracion;
import com.elfogon.model.Pedido;

import java.util.List;

public interface IValoracionService extends IGenericService<Valoracion, Integer> {

    // Método específico: Obtener la valoración de un pedido (único)
    Valoracion findByPedido(Pedido pedido) throws Exception;

    // Método específico: Encontrar valoraciones con una calificación mínima (Ej: >= 4)
    List<Valoracion> findByMinRating(Integer calificacionMinima) throws Exception;
}