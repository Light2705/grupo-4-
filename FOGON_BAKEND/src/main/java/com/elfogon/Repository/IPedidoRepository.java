package com.elfogon.Repository; // Asegúrate de que el paquete sea el correcto

import com.elfogon.model.Pedido;
import com.elfogon.model.Cliente; // Importamos Cliente para la búsqueda
import com.elfogon.model.Empleado; // Importamos Empleado para la búsqueda
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPedidoRepository extends  IGenericRepository<Pedido, Integer> {

    // Método para encontrar pedidos por su estado (ej: "Pendiente", "En Preparación", "Entregado")
    List<Pedido> findByEstado(String estado);

    // Método para encontrar todos los pedidos realizados por un cliente específico
    List<Pedido> findByCliente(Cliente cliente);

    // Método para encontrar pedidos gestionados por un empleado específico
    List<Pedido> findByEmpleadoGestor(Empleado empleado);

    // Método para encontrar pedidos dentro de un rango de fechas
    List<Pedido> findByFechaHoraPedidoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // Método para encontrar pedidos por tipo (ej: "Domicilio", "Mesa", "Recoger")
    List<Pedido> findByTipoPedido(String tipoPedido);
}