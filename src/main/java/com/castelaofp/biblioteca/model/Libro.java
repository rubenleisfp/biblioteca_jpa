package com.castelaofp.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

//TODO Faltan las anotaciones
@Entity
@Table(name="Libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name="autor")
	private String autor;

	// FIXME: No debemos usar EAGER, lo usamos porque en este caso de proyecto Standalone, no carga bien las LazyCollections
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "libro", cascade = CascadeType.ALL)
    private List<Ejemplar> ejemplares = new ArrayList<>();


	// getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	@Override
	public String toString() {
		return "Libro{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", autor='" + autor + '\'' +
				", ejemplares=" + ejemplares +
				'}';
	}
}