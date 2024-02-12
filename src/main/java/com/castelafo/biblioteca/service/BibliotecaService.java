package com.castelafo.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castelafo.biblioteca.model.Ejemplar;
import com.castelafo.biblioteca.model.Libro;
import com.castelafo.biblioteca.repository.EjemplarRepository;
import com.castelafo.biblioteca.repository.LibroRepository;

@Service
public class BibliotecaService {
	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private EjemplarRepository ejemplarRepository;

	public void agregarLibroConEjemplares(Libro libro, List<Ejemplar> ejemplares) {
		libro.setEjemplares(ejemplares);
		libroRepository.save(libro);
	}

	public List<Ejemplar> obtenerEjemplaresDeLibro(Long libroId) {
		Optional<Libro> optionalLibro = libroRepository.findById(libroId);

		if (optionalLibro.isPresent()) {
			Libro libro = optionalLibro.get();
			return ejemplarRepository.findByLibro(libro);
		} else {
			return new ArrayList<>();
		}
	}
}