package com.laptopstore.entities;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "marcas")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marca_id")
	private Integer marcaId;

	@Column(name = "nombre_marca", length = 50, nullable = false)
	private String nombreMarca;

}
