package com.elfogon.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoDTO {

    private Integer idPedido;

    @NotNull(message = "La fecha y hora del pedido son obligatorias")
    private LocalDateTime fechaHoraPedido;

    @NotNull(message = "El estado del pedido es obligatorio")
    @Size(max = 30, message = "El estado no puede tener más de 30 caracteres")
    private String estado;

    @NotNull(message = "El monto total es obligatorio")
    private Double montoTotal;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Integer idCliente;

    private Integer idEmpleadoGestor; // Puede ser nulo si aún no se asigna un empleado

    @NotNull(message = "El tipo de pedido es obligatorio")
    @Size(max = 20, message = "El tipo de pedido no puede tener más de 20 caracteres")
    private String tipoPedido; // Ejemplo: "Domicilio", "Mesa", "Recoger"

    @Size(max = 255, message = "La dirección no puede tener más de 255 caracteres")
    private String direccionEntrega;

    private Double costoEnvio;

    @Size(max = 255, message = "Las notas del cliente no pueden tener más de 255 caracteres")
    private String notasCliente;
}
