package com.laptopstore.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventario")
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventario_id")
	private Long inventorioId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "producto_id", nullable = false)
	private Producto producto;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "ultima_actualizacion", nullable = false)
	private LocalDateTime ultimaActualizacion;

	@PrePersist
	private void inicializarFechaActualizacion() {
		this.ultimaActualizacion = LocalDateTime.now();
	}

}