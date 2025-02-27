package com.castelaofp.biblioteca.model;

import jakarta.persistence.*;

//TODO Falta las anotaciones
@Entity
@Table(name="Ejemplar")
public class Ejemplar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numeroEjemplar;
	private String estado;

	@ManyToOne
	@JoinColumn(name = "libro_id")
	private Libro libro;

	// getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroEjemplar() {
		return numeroEjemplar;
	}

	public void setNumeroEjemplar(String numeroEjemplar) {
		this.numeroEjemplar = numeroEjemplar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
}