package com.elfogon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pedidos")
public class Pedido {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @Column(nullable = false)
    private LocalDateTime fechaHoraPedido;

    @Column(nullable = false, length = 30)
    private String estado;

    @Column(nullable = false)
    private Double montoTotal;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_PEDIDO_CLIENTE"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado_gestion", foreignKey = @ForeignKey(name = "FK_PEDIDO_EMPLEADO"))
    private Empleado empleadoGestor;

    @Column(nullable = false, length = 20)
    private String tipoPedido;

    @Column(length = 255)
    private String direccionEntrega;

    @Column
    private Double costoEnvio;

    @Column(length = 255)
    private String notasCliente;
}