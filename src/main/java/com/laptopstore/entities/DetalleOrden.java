package com.laptopstore.entities;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalles_orden")
public class DetalleOrden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detalle_orden_id")
	private Long detalleOrdenId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orden_id", referencedColumnName = "orden_id", nullable = false)
	private Orden orden;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id", referencedColumnName = "producto_id", nullable = false)
	private Producto producto;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

}
