package com.fp.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

//TODO Faltan las anotaciones
public class Libro {

	private Long id;
	private String titulo;
	private String autor;

	// FIXME: No debemos usar EAGER
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