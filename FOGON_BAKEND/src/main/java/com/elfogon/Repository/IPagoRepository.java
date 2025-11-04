package com.elfogon.Repository; // Asegúrate de que el paquete sea el correcto

import com.elfogon.model.Pago;
import com.elfogon.model.Pedido; // Importamos Pedido para la búsqueda
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPagoRepository extends  IGenericRepository<Pago, Integer> {

    // Método para encontrar un pago dado un pedido.
    // Es único porque la relación es OneToOne y unique=true en la entidad.
    Pago findByPedido(Pedido pedido);

    // Método para encontrar pagos por su método (ej: "Tarjeta", "Efectivo", "Transferencia")
    List<Pago> findByMetodoPago(String metodoPago);

    // Método para encontrar pagos por su estado (ej: "Completado", "Pendiente", "Fallido")
    List<Pago> findByEstadoTransaccion(String estadoTransaccion);

    // Método para encontrar pagos dentro de un rango de fechas
    List<Pago> findByFechaHoraPagoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // Método para encontrar pagos por referencia de transacción (si se usa)
    Pago findByReferenciaTransaccion(String referenciaTransaccion);
}