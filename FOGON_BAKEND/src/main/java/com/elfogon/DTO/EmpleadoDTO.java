package com.elfogon.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmpleadoDTO {

    private Integer idEmpleado;

    @NotBlank(message = "El nombre del empleado es obligatorio")
    @Size(max = 70, message = "El nombre no puede tener más de 70 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido del empleado es obligatorio")
    @Size(max = 70, message = "El apellido no puede tener más de 70 caracteres")
    private String apellido;

    @NotBlank(message = "El DNI es obligatorio")
    @Size(max = 15, message = "El DNI no puede tener más de 15 caracteres")
    private String dni;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(max = 30, message = "El teléfono no puede tener más de 30 caracteres")
    private String telefono;

    @Email(message = "Debe ingresar un correo válido")
    @Size(max = 100, message = "El correo no puede tener más de 100 caracteres")
    private String email;

    @NotBlank(message = "El cargo es obligatorio")
    @Size(max = 50, message = "El cargo no puede tener más de 50 caracteres")
    private String cargo;

    @NotBlank(message = "El estado es obligatorio (por ejemplo: Activo, Inactivo)")
    @Size(max = 20, message = "El estado no puede tener más de 20 caracteres")
    private String estado;
}
