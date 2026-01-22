package com.challenge.literalura.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;
    
    private String titulo;
    


}
