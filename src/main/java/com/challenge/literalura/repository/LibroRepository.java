package com.challenge.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.literalura.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository <Libro, Long> {

    boolean existsByTitulo(String titulo);

}
