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
@Table(name = "pagos")
public class Pago {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;

    @OneToOne
    @JoinColumn(name = "id_pedido", nullable = false, unique = true, foreignKey = @ForeignKey(name = "FK_PAGO_PEDIDO"))
    private Pedido pedido;

    @Column(nullable = false)
    private LocalDateTime fechaHoraPago;

    @Column(nullable = false)
    private Double montoPagado;

    @Column(nullable = false, length = 50)
    private String metodoPago;

    @Column(nullable = false, length = 30)
    private String estadoTransaccion;

    @Column(length = 100)
    private String referenciaTransaccion;
}