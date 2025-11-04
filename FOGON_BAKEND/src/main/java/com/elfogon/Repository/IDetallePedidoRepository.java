package com.elfogon.Repository; // Asegúrate de que el paquete sea el correcto

import com.elfogon.model.DetallePedido;
import com.elfogon.model.Pedido; // Importamos Pedido para la búsqueda
import com.elfogon.model.Plato; // Importamos Plato para la búsqueda
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetallePedidoRepository extends  IGenericRepository<DetallePedido, Integer> {

    // Método para obtener todos los detalles asociados a un pedido específico
    // Esto es crucial para la visualización y preparación del pedido.
    List<DetallePedido> findByPedido(Pedido pedido);

    // Método para encontrar detalles que incluyen un plato específico
    // Útil para saber cuántas veces se ha pedido un plato.
    List<DetallePedido> findByPlato(Plato plato);

    // Método para encontrar detalles donde la cantidad pedida es mayor o igual a un valor
    List<DetallePedido> findByCantidadGreaterThanEqual(Integer cantidad);

    // Método para encontrar detalles donde se ha especificado alguna personalización
    List<DetallePedido> findByPersonalizacionIsNotNull();

}