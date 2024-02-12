package com.castelafo.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castelafo.biblioteca.model.Ejemplar;
import com.castelafo.biblioteca.model.Libro;

public interface EjemplarRepository extends JpaRepository<Ejemplar, Long> {
    List<Ejemplar> findByLibro(Libro libro);
}
