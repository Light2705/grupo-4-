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
@Table(name = "ingredientes")
public class Ingrediente {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIngrediente;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String unidadMedida; // Ej: kg, litro, unidad

    @Column(nullable = false)
    private Double stockActual; // Cantidad en inventario

    @Column(nullable = false)
    private Double stockMinimo; // Alerta de stock

    @ManyToOne
    @JoinColumn(name="id_proveedor_principal", foreignKey = @ForeignKey(name = "FK_INGREDIENTE_PROVEEDOR"))
    private Proveedor proveedorPrincipal;
}