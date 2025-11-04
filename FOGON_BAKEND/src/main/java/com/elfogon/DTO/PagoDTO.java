package com.elfogon.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PagoDTO {

    private Integer idPago;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Integer idPedido; // Referencia al pedido asociado

    @NotNull(message = "El monto del pago es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El monto debe ser mayor que 0")
    private Double monto;

    @NotNull(message = "La fecha de pago es obligatoria")
    private LocalDateTime fechaPago;

    @NotNull(message = "El método de pago es obligatorio")
    @Size(max = 50, message = "El método de pago no puede tener más de 50 caracteres")
    private String metodoPago; // Ejemplo: "Tarjeta", "Efectivo", "Yape", etc.

    @Size(max = 255, message = "El estado del pago no puede tener más de 255 caracteres")
    private String estado; // Ejemplo: "Completado", "Pendiente", "Rechazado"

    @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres")
    private String descripcion;
}
