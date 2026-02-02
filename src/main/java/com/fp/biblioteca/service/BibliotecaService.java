package com.fp.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.biblioteca.dto.EjemplarDto;
import com.fp.biblioteca.dto.LibroDto;
import com.fp.biblioteca.repository.EjemplarRepository;
import com.fp.biblioteca.repository.LibroRepository;
import com.fp.biblioteca.service.exceptions.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

//TODO: A completar por el alumno
@Service
public class BibliotecaService {

	private static Logger LOG = LoggerFactory.getLogger(BibliotecaService.class);

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private EjemplarRepository ejemplarRepository;

	/**
	 * Crea un nuevo libro
	 * 
	 * @param libroDto
	 * @return
	 */
	public LibroDto createLibro(LibroDto libroDto) {
		throw new UnsupportedOperationException("Falta por implementar");
	};

	/**
	 * Crea un ejemplar nuevo asociado al libro recibida como argumento
	 * 
	 * Devuelve el ejemplar recien creado
	 * Devuelve una excepcion NotFound sino existe el libro.
	 * @param libroId
	 * @param ejemplarDto
	 * @return
	 * @throws NotFoundException
	 */
	public EjemplarDto createEjemplar(Long libroId, EjemplarDto ejemplarDto) throws NotFoundException {
		throw new UnsupportedOperationException("Falta por implementar");

	}

	/**
	 * Devuelve la lista con todos los libros
	 * 
	 * @return
	 */
    @Transactional(readOnly = true)
	public List<LibroDto> findAllLibros() {
		throw new UnsupportedOperationException("Falta por implementar");
	}

	/**
	 * Para el id proporcionado, devuelve el libro si existe
	 * 
	 * @param libroId
	 * @return
	 */
    @Transactional(readOnly = true)
	public Optional<LibroDto> getById(Long libroId) {
		throw new UnsupportedOperationException("Falta por implementar");

	}
}