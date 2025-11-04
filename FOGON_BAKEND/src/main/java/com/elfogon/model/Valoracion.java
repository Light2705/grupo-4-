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
@Table(name = "valoraciones")
public class Valoracion {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idValoracion;

    @OneToOne
    @JoinColumn(name = "id_pedido", nullable = false, unique = true, foreignKey = @ForeignKey(name = "FK_VALORACION_PEDIDO"))
    private Pedido pedido;

    @Column(nullable = false)
    private Integer calificacion;

    @Column(length = 500)
    private String comentario;

    @Column(nullable = false)
    private LocalDateTime fechaValoracion;
}