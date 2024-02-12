package com.castelafo.biblioteca;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.castelafo.biblioteca.model.Ejemplar;
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
		Libro nuevoLibro = new Libro();
		nuevoLibro.setTitulo("El Señor de los Anillos");
		nuevoLibro.setAutor("J.R.R. Tolkien");
		nuevoLibro.setIsbn("978-84-450-7629-5");

		// Crear ejemplares para el libro
		Ejemplar ejemplar1 = new Ejemplar();
		ejemplar1.setNumeroEjemplar("EJ001");
		ejemplar1.setEstado("Disponible");

		Ejemplar ejemplar2 = new Ejemplar();
		ejemplar2.setNumeroEjemplar("EJ002");
		ejemplar2.setEstado("Prestado");

		List<Ejemplar> ejemplares = Arrays.asList(ejemplar1, ejemplar2);

		// Llamar al servicio para agregar el libro con ejemplares
		bibliotecaService.agregarLibroConEjemplares(nuevoLibro, ejemplares);

		// Llamar al servicio para obtener los ejemplares de un libro específico
		Long libroId = nuevoLibro.getId();
		List<Ejemplar> ejemplaresDelLibro = bibliotecaService.obtenerEjemplaresDeLibro(libroId);

		// Imprimir los ejemplares del libro
		System.out.println("Ejemplares del libro con ID " + libroId + ":");
		for (Ejemplar ejemplar : ejemplaresDelLibro) {
			System.out.println(
					"Número de ejemplar: " + ejemplar.getNumeroEjemplar() + ", Estado: " + ejemplar.getEstado());
		}

	}

}
