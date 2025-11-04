package com.elfogon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "empleados")
public class Empleado {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    @Column(nullable = false, length = 70)
    private String nombre;

    @Column(nullable = false, length = 70)
    private String apellido;

    @Column(nullable = false, length = 50)
    private String rol; // Ej: Cocinero, Cajero, Administrador

    @Column(nullable = false, length = 30, unique = true)
    private String numeroDocumento;

    @Column(length = 30)
    private String telefono;
}
