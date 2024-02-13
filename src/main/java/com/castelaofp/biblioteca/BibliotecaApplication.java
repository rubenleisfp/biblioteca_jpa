package com.castelaofp.biblioteca;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.castelaofp.biblioteca.dto.EjemplarDto;
import com.castelaofp.biblioteca.dto.LibroDto;
import com.castelaofp.biblioteca.mapper.LibroMapper;
import com.castelaofp.biblioteca.model.Libro;
import com.castelaofp.biblioteca.service.BibliotecaService;
import com.castelaofp.biblioteca.service.exceptions.NotFoundException;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

	@Autowired
	private BibliotecaService bibliotecaService;

	private final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			System.out.println("Menú:");
			System.out.println("1. Crear libro");
			System.out.println("2. Crear ejemplar");
			System.out.println("3. Mostrar todos los libros");
			System.out.println("0. Salir");

			System.out.print("Seleccione una opción: ");
			int opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir la nueva línea después de la opción

			switch (opcion) {
			case 1:
				crearLibro();
				break;
			case 2:
				crearEjemplar();
				break;
			case 3:
				mostrarTodosLosLibros();
				break;
			case 0:
				System.out.println("Saliendo...");
				System.exit(0);
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}
		}
	}

	private void crearLibro() {
		LibroDto nuevoLibroDto = new LibroDto();
		nuevoLibroDto.setTitulo("El Señor de los Anillos");
		nuevoLibroDto.setAutor("J.R.R. Tolkien");
		nuevoLibroDto.setIsbn("978-84-450-7629-5");

		bibliotecaService.createLibro(nuevoLibroDto);
		System.out.println("Libro creado exitosamente.");
	}

	private void crearEjemplar() throws NotFoundException {
		System.out.print("Ingrese el ID del libro para el cual desea crear un ejemplar: ");
		Long libroId = scanner.nextLong();
		scanner.nextLine(); // Consumir la nueva línea después del ID

		// Crear ejemplares para el libro
		EjemplarDto ejemplarDto = new EjemplarDto();
		ejemplarDto.setNumeroEjemplar("EJ001");
		ejemplarDto.setEstado("Disponible");

		bibliotecaService.createEjemplar(libroId, ejemplarDto);
		System.out.println("Ejemplar creado exitosamente.");
	}

	private void mostrarTodosLosLibros() {
		List<Libro> libros = bibliotecaService.findAllLibros();
		for (Libro libro : libros) {
			LibroDto dto = LibroMapper.toDto(libro);
			System.out.println("Libro: " + dto);
		}
	}
}
