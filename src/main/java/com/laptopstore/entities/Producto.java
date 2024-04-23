package com.laptopstore.entities;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private Long productoId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;

	@Column(name = "codigo_producto", length = 50, nullable = false)
	private String codigoProducto;

	@Column(name = "nombre_producto", length = 50, nullable = false)
	private String nombreProducto;

	@Column(name = "descripcion_producto", nullable = false, columnDefinition = "TEXT")
	private String descripcionProducto;

	private Double precio;

	private Double oferta;
}