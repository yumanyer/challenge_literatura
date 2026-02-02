package com.challenge.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.literalura.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository <Libro, Long> {

    boolean existsByTitulo(String titulo);
    
@Query("SELECT DISTINCT l.idioma FROM Libro l")
List<String> findDistinctIdiomas();

List<Libro> findByIdioma(String idioma);


    
}
