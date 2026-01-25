package com.challenge.literalura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.literalura.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional <Autor> findByNombre(String name);
}
