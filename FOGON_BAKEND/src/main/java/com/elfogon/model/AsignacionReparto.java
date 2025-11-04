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
@Table(name = "asignaciones_reparto")
public class AsignacionReparto {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignacion;

    @OneToOne
    @JoinColumn(name = "id_pedido", nullable = false, unique = true, foreignKey = @ForeignKey(name = "FK_ASIGNACION_PEDIDO"))
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_repartidor", nullable = false, foreignKey = @ForeignKey(name = "FK_ASIGNACION_REPARTIDOR"))
    private Repartidor repartidor;

    @Column(nullable = false)
    private LocalDateTime horaAsignacion;

    @Column
    private LocalDateTime horaSalida;

    @Column
    private LocalDateTime horaEntrega;

    @Column(nullable = false, length = 30)
    private String estadoReparto;
}