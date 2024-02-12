package com.castelafo.biblioteca;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.castelafo.biblioteca.dto.EjemplarDto;
import com.castelafo.biblioteca.dto.LibroDto;
import com.castelafo.biblioteca.mapper.LibroMapper;
import com.castelafo.biblioteca.model.Libro;
import com.castelafo.biblioteca.service.BibliotecaService;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

	@Autowired
	BibliotecaService bibliotecaService;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Crear un nuevo libro
		LibroDto nuevoLibroDto = new LibroDto();
		nuevoLibroDto.setTitulo("El Señor de los Anillos");
		nuevoLibroDto.setAutor("J.R.R. Tolkien");
		nuevoLibroDto.setIsbn("978-84-450-7629-5");

		// Crear ejemplares para el libro
		EjemplarDto ejemplarDto1 = new EjemplarDto();
		ejemplarDto1.setNumeroEjemplar("EJ001");
		ejemplarDto1.setEstado("Disponible");

		EjemplarDto ejemplarDto2 = new EjemplarDto();
		ejemplarDto2.setNumeroEjemplar("EJ002");
		ejemplarDto2.setEstado("Prestado");

		List<EjemplarDto> ejemplares = Arrays.asList(ejemplarDto1, ejemplarDto2);

		// Llamar al servicio para agregar el libro con ejemplares
		LibroDto libroCreado = bibliotecaService.createLibro(nuevoLibroDto);

		// Llamar al servicio para obtener los ejemplares de un libro específico
		Long libroId = nuevoLibroDto.getId();
		EjemplarDto ejemplarLibro = bibliotecaService.createEjemplar(libroCreado.getId(), ejemplarDto1);
		System.out.println("EjemplarLibro 1 Creado: " + ejemplarLibro);

		ejemplarLibro = bibliotecaService.createEjemplar(libroCreado.getId(), ejemplarDto2);
		System.out.println("EjemplarLibro 2 Creado: " + ejemplarLibro);

		// Imprimir los ejemplares del libro
		System.out.println("Ejemplares del libro con ID " + libroId + ":");
		List<Libro> libros = bibliotecaService.findAllLibros();
		for (Libro libro : libros) {
			LibroDto libroDto = LibroMapper.toDto(libro);
			System.out.println("Libro: " + libroDto);
		}

	}

}
