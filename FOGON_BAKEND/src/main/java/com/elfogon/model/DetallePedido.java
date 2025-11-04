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
@Table(name = "detalles_pedido")
public class DetallePedido {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetallePedido;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_PEDIDO"))
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_plato", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_PLATO"))
    private Plato plato;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double precioUnitario;

    @Column(length = 255)
    private String personalizacion;
}