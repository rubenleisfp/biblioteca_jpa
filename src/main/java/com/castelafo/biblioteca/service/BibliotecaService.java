package com.castelafo.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castelafo.biblioteca.dto.EjemplarDto;
import com.castelafo.biblioteca.dto.LibroDto;
import com.castelafo.biblioteca.mapper.EjemplarMapper;
import com.castelafo.biblioteca.mapper.LibroMapper;
import com.castelafo.biblioteca.model.Ejemplar;
import com.castelafo.biblioteca.model.Libro;
import com.castelafo.biblioteca.repository.EjemplarRepository;
import com.castelafo.biblioteca.repository.LibroRepository;
import com.castelafo.biblioteca.service.exceptions.NotFoundException;

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
	 * @param libro
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
	 * @throws UploadException
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
	public List<Libro> findAllLibros() {
		return libroRepository.findAll();
	}

	/**
	 * Para el id proporcionado, devuelve el libro si existe
	 * 
	 * @param libroId
	 * @return
	 */
	public Optional<Libro> getById(Long libroId) {
		Optional<Libro> libro = libroRepository.findById(libroId);
		return libro;
	}
}