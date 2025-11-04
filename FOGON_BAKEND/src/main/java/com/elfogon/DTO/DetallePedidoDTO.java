package com.elfogon.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DetallePedidoDTO {

    private Integer idDetallePedido;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Integer idPedido; // Relación con Pedido, solo se maneja el ID

    @NotNull(message = "El ID del plato es obligatorio")
    private Integer idPlato; // Relación con Plato, solo se maneja el ID

    @NotNull(message = "La cantidad es obligatoria")
    @Positive(message = "La cantidad debe ser un valor positivo")
    private Integer cantidad;

    @NotNull(message = "El precio unitario es obligatorio")
    @Positive(message = "El precio unitario debe ser un valor positivo")
    private Double precioUnitario;

    @Size(max = 255, message = "La personalización no puede tener más de 255 caracteres")
    private String personalizacion; // Opcional
}
