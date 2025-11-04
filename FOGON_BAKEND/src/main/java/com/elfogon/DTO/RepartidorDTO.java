package com.elfogon.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.Pattern;

@Data
public class RepartidorDTO {

    private Integer idRepartidor;

    @NotNull(message = "El nombre es obligatorio")
    @Size(max = 70, message = "El nombre no puede tener más de 70 caracteres")
    private String nombre;

    @NotNull(message = "El apellido es obligatorio")
    @Size(max = 70, message = "El apellido no puede tener más de 70 caracteres")
    private String apellido;

    @NotNull(message = "El teléfono es obligatorio")
    @Size(max = 30, message = "El teléfono no puede tener más de 30 caracteres")
    @Pattern(regexp = "\\d+", message = "El teléfono debe contener solo números")
    private String telefono;

    @NotNull(message = "La disponibilidad es obligatoria")
    @Size(max = 30, message = "La disponibilidad no puede tener más de 30 caracteres")
    private String disponibilidad; // Ejemplo: "Disponible", "No disponible"
}
