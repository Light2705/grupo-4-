package com.elfogon.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PlatoDTO {

    private Integer idPlato;

    @NotNull(message = "El nombre del plato es obligatorio")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombre;

    @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser un valor positivo")
    private Double precio;

    @NotNull(message = "El estado de disponibilidad es obligatorio")
    private Boolean disponible = true;

    @NotNull(message = "La categoría es obligatoria")
    @Size(max = 50, message = "La categoría no puede tener más de 50 caracteres")
    private String categoria;
}
