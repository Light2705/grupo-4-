package com.elfogon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idProveedor;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, length = 15, unique = true)
    private String ruc;

    @Column(length = 30)
    private String telefono;

    @Column(length = 60)
    private String email;

    @Column(length = 150)
    private String direccion;
}