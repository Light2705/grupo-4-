package com.elfogon.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteDTO {

    private Integer idCliente;

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 70, message = "El nombre no puede tener más de 70 caracteres.")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio.")
    @Size(max = 70, message = "El apellido no puede tener más de 70 caracteres.")
    private String apellido;

    @NotBlank(message = "El número de documento es obligatorio.")
    @Size(max = 30, message = "El número de documento no puede tener más de 30 caracteres.")
    private String numeroDocumento;

    @Size(max = 30, message = "El teléfono no puede tener más de 30 caracteres.")
    private String telefono;

    @Email(message = "Debe ingresar un correo electrónico válido.")
    @Size(max = 100, message = "El correo no puede tener más de 100 caracteres.")
    private String email;

    @Size(max = 255, message = "La dirección no puede tener más de 255 caracteres.")
    private String direccion;
}
