package com.castelaofp.biblioteca.dto;

import java.util.ArrayList;
import java.util.List;

public class LibroDto {

	private Long id;
	private String titulo;
	private String autor;
	private String isbn;
	private List<EjemplarDto> ejemplares = new ArrayList<>();

	public LibroDto(Long id, String titulo, String autor, String isbn) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<EjemplarDto> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(List<EjemplarDto> ejemplares) {
		this.ejemplares = ejemplares;
	}

	@Override
	public String toString() {
		return "LibroDto [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", ejemplares="
				+ ejemplares + "]";
	}
	
	
}