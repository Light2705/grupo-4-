package com.elfogon.Repository;

import com.elfogon.model.AsignacionReparto;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAsignacionRepartoRepository extends  IGenericRepository<AsignacionReparto, Integer> {

    // 1. Buscar asignaciones por el ID del repartidor
    List<AsignacionReparto> findByRepartidorIdRepartidor(Integer idRepartidor);

    // 2. Buscar una asignación por el estado del reparto (útil para ver pendientes o en curso)
    List<AsignacionReparto> findByEstadoReparto(String estadoReparto);

    // 3. Buscar una asignación por el ID del pedido (ya que la relación es @OneToOne y unique)
    Optional<AsignacionReparto> findByPedidoIdPedido(Integer idPedido);
}