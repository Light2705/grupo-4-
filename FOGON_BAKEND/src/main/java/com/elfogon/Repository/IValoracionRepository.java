package com.elfogon.Repository; // Asegúrate de que el paquete sea el correcto

import com.elfogon.model.Valoracion;
import com.elfogon.model.Pedido; // Importamos Pedido para la búsqueda
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IValoracionRepository extends  IGenericRepository<Valoracion, Integer> {

    // Método para encontrar una valoración dado un pedido.
    // Es único porque la relación es OneToOne y unique=true en la entidad.
    Valoracion findByPedido(Pedido pedido);

    // Método para obtener todas las valoraciones con una calificación específica (ej: 5 estrellas)
    List<Valoracion> findByCalificacion(Integer calificacion);

    // Método para encontrar valoraciones en un rango de fechas
    List<Valoracion> findByFechaValoracionBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // Método para encontrar valoraciones con una calificación mayor o igual a un valor dado
    List<Valoracion> findByCalificacionGreaterThanEqual(Integer calificacion);
}