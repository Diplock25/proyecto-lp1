package com.laptopstore.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordenes")
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orden_id")
	private Long ordenId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id", nullable = false)
	private Cliente cliente;

	@Column(name = "fecha_orden", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime fechaOrden;

	@Column(name = "estado", length = 25, nullable = false)
	private String estado;

	@Column(name = "monto_total")
	private BigDecimal montoTotal;
}