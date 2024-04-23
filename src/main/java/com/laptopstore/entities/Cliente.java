package com.laptopstore.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Long clienteId;

	@Column(name = "nombres", length = 50, nullable = false)
	private String nombres;

	@Column(name = "apellidos", length = 50, nullable = false)
	private String apellidos;

	@Column(name = "correo", length = 100)
	private String correo;

	@Column(name = "telefono", length = 25)
	private String telefono;

	@Column(name = "direccion", columnDefinition = "TEXT")
	private String direccion;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Orden> ordenes;

}
