package com.elfogon.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ProveedorDTO {

    private Integer idProveedor;

    @NotNull(message = "El nombre del proveedor es obligatorio")
    @Size(max = 150, message = "El nombre no puede tener más de 150 caracteres")
    private String nombre;

    @NotNull(message = "El RUC es obligatorio")
    @Size(max = 15, message = "El RUC no puede tener más de 15 caracteres")
    @Pattern(regexp = "\\d+", message = "El RUC debe contener solo números")
    private String ruc;

    @Size(max = 30, message = "El teléfono no puede tener más de 30 caracteres")
    private String telefono;

    @Size(max = 60, message = "El email no puede tener más de 60 caracteres")
    private String email;

    @Size(max = 150, message = "La dirección no puede tener más de 150 caracteres")
    private String direccion;
}
