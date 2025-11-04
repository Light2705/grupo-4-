package com.elfogon.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class IngredienteDTO {

    private Integer idIngrediente;

    @NotNull(message = "El nombre del ingrediente es obligatorio")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombre;

    @NotNull(message = "La unidad de medida es obligatoria")
    @Size(max = 30, message = "La unidad de medida no puede tener más de 30 caracteres")
    private String unidadMedida; // Ej: kg, litro, unidad

    @NotNull(message = "El stock actual es obligatorio")
    @PositiveOrZero(message = "El stock actual no puede ser negativo")
    private Double stockActual;

    @NotNull(message = "El stock mínimo es obligatorio")
    @PositiveOrZero(message = "El stock mínimo no puede ser negativo")
    private Double stockMinimo;

    private Integer idProveedorPrincipal; // Relación con Proveedor, solo se maneja el ID
}
