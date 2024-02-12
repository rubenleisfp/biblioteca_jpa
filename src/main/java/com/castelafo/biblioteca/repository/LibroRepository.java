package com.castelafo.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castelafo.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}

