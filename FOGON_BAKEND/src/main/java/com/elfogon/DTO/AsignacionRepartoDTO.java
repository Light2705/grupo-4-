package com.elfogon.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AsignacionRepartoDTO {

    private Integer idAsignacion;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Integer idPedido; // Relación con Pedido, solo se maneja el ID

    @NotNull(message = "El ID del repartidor es obligatorio")
    private Integer idRepartidor; // Relación con Repartidor, solo se maneja el ID

    @NotNull(message = "La hora de asignación es obligatoria")
    private LocalDateTime horaAsignacion;

    private LocalDateTime horaSalida;

    private LocalDateTime horaEntrega;

    @NotNull(message = "El estado del reparto es obligatorio")
    @Size(max = 30, message = "El estado del reparto no puede tener más de 30 caracteres")
    private String estadoReparto; // Ej: "En camino", "Entregado", "Pendiente"
}
