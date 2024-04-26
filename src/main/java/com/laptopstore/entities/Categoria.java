package com.laptopstore.entities;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoria_id")
	private int categoriaId;

	@Column(name = "nombre_categoria", length = 50, nullable = false)
	private String nombreCategoria;

}
