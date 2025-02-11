package com.castelaofp.biblioteca.dto;

import java.util.ArrayList;
import java.util.List;

public class LibroDto {

	private Long id;
	private String titulo;
	private String autor;
	private List<EjemplarDto> ejemplares = new ArrayList<>();

	public LibroDto(Long id, String titulo, String autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
	}

	public LibroDto() {

	}

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

	public List<EjemplarDto> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(List<EjemplarDto> ejemplares) {
		this.ejemplares = ejemplares;
	}

	@Override
	public String toString() {
		return "LibroDto{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", autor='" + autor + '\'' +
				", ejemplares=" + ejemplares +
				'}';
	}
}