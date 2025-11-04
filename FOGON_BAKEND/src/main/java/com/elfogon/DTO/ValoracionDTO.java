package com.elfogon.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ValoracionDTO {

    private Integer idValoracion;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Integer idPedido; // Relación con Pedido, se guarda solo el ID

    @NotNull(message = "La calificación es obligatoria")
    @Min(value = 1, message = "La calificación mínima es 1")
    @Max(value = 5, message = "La calificación máxima es 5")
    private Integer calificacion;

    @Size(max = 500, message = "El comentario no puede tener más de 500 caracteres")
    private String comentario;

    @NotNull(message = "La fecha de valoración es obligatoria")
    private LocalDateTime fechaValoracion;
}
