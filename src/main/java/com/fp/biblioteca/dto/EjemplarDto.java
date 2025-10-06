package com.fp.biblioteca.dto;

public class EjemplarDto {

	private Long id;
	private String numeroEjemplar;
	private String estado;
	private LibroDto libro;

	public EjemplarDto() {
		super();
	}

	public EjemplarDto(Long id, String numeroEjemplar, String estado) {
		super();
		this.id = id;
		this.numeroEjemplar = numeroEjemplar;
		this.estado = estado;

	}

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

	public LibroDto getLibro() {
		return libro;
	}

	public void setLibro(LibroDto libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "EjemplarDto [id=" + id + ", numeroEjemplar=" + numeroEjemplar + ", estado=" + estado + ", libro="
				+ libro + "]";
	}

}