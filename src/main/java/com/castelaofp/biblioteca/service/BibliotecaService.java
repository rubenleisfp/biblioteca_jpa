package com.castelaofp.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castelaofp.biblioteca.dto.EjemplarDto;
import com.castelaofp.biblioteca.dto.LibroDto;
import com.castelaofp.biblioteca.mapper.EjemplarMapper;
import com.castelaofp.biblioteca.mapper.LibroMapper;
import com.castelaofp.biblioteca.model.Ejemplar;
import com.castelaofp.biblioteca.model.Libro;
import com.castelaofp.biblioteca.repository.EjemplarRepository;
import com.castelaofp.biblioteca.repository.LibroRepository;
import com.castelaofp.biblioteca.service.exceptions.NotFoundException;

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
		Libro libro = LibroMapper.toEntity(libroDto);
		libro = libroRepository.save(libro);
		LibroDto dtoCreated = LibroMapper.toDto(libro);
		return dtoCreated;
	};

	/**
	 * Crea un ejemplar nuevo asociado al libro recibida como argumento
	 *
	 * Devuelve el ejemplar recien creado
	 *
	 * @param libroId
	 * @param ejemplarDto
	 * @return
	 * @throws NotFoundException
	 */
	public EjemplarDto createEjemplar(Long libroId, EjemplarDto ejemplarDto) throws NotFoundException {
		Optional<Libro> libro = libroRepository.findById(libroId);
		if (libro.isEmpty()) {
			LOG.error("No existe el libro con id: " + libro);
			LOG.error("EjemplarDto " + ejemplarDto);
			throw new NotFoundException("No existe el libro con id: " + libro);
		} else {

			Ejemplar ejemplar = EjemplarMapper.toEntity(ejemplarDto);
			ejemplar.setLibro(libro.get());
			ejemplar = ejemplarRepository.save(ejemplar);
			ejemplarDto = EjemplarMapper.toDto(ejemplar);

			return ejemplarDto;
		}
	}

	/**
	 * Devuelve la lista con todos los libros
	 *
	 * @return
	 */
	public List<LibroDto> findAllLibros() {
		return LibroMapper.toDto(libroRepository.findAll());

	}

	/**
	 * Para el id proporcionado, devuelve el libro si existe
	 *
	 * @param libroId
	 * @return
	 */
	public Optional<LibroDto> getById(Long libroId) {
		Optional<Libro> libro = libroRepository.findById(libroId);
		if (libro.isPresent()) {
			return Optional.of(LibroMapper.toDto(libro.get()));
		} else {
			LOG.warn("No se encontró el libro con id: " + libroId);
			return Optional.empty();
		}

	}
}