package com.challenge.literalura.Principal;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.challenge.literalura.model.Autor;
import com.challenge.literalura.model.DatosLibro;
import com.challenge.literalura.model.Libro;
import com.challenge.literalura.model.RespuestaGutendex;
import com.challenge.literalura.repository.AutorRepository;
import com.challenge.literalura.repository.LibroRepository;
import com.challenge.literalura.service.ConsumoAPI;
import com.challenge.literalura.service.ConvierteDatos;

@Component
public class Principal {

    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final ConvierteDatos conversor = new ConvierteDatos();
    private final Scanner sc = new Scanner(System.in);

    private final AutorRepository autorRepo;
    private final LibroRepository libroRepo;

    private static final String URL = "https://gutendex.com/books/?search=";

    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";

    
    public Principal(AutorRepository autorRepo, LibroRepository libroRepo) {
        this.autorRepo = autorRepo;
        this.libroRepo = libroRepo;
    }

    public void iniciar() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println(ANSI_PURPLE + "\n¿Qué operacion desea  hacer?" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "1. Buscar libro por título" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "2. Listar libros registrados" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "3. Listar autores registrados" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "4. Listar autores vivos en un año determinado" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "5. Listar libro por idioma" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "0. Salir" + ANSI_RESET);

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> buscarLibroPorTitulo();
                case 2 -> System.out.println("Listar libros registrados (pendiente DB)");
                case 3 -> System.out.println("Listar autores registrados (pendiente DB)");
                case 4 -> System.out.println("Autores vivos en un año (pendiente DB)");
                case 5 -> System.out.println("Listar libros por idioma (pendiente DB)");
                case 0 -> System.out.println("Salir");
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = sc.nextLine();

        String json = consumoAPI.obtenerDatos(URL + titulo.replace(" ", "%20"));

        RespuestaGutendex respuesta =
                conversor.obtenerDatos(json, RespuestaGutendex.class);

        if (respuesta.results() == null || respuesta.results().isEmpty()) {
            System.out.println("No se encontraron libros.");
            return;
        }

        // TOMAMOS EL PRIMERO
DatosLibro libro = respuesta.results().get(0);

    if(libroRepo.existsByTitulo(libro.titulo())){
        System.out.println(ANSI_RED + "El libro ya existe en la base de datos" + ANSI_RESET);
        return;
    }

    var autorApi = libro.autores().get(0);

Autor autor = autorRepo
        .findByNombre(autorApi.name())
        .orElseGet(() -> {
            Autor nuevo = new Autor();
            nuevo.setNombre(autorApi.name());
            nuevo.setAño_Nacimiento(autorApi.birthYear());
            nuevo.setAño_Muerte(autorApi.deathYear());
            return autorRepo.save(nuevo);
        });

Libro libroEntidad = new Libro();
libroEntidad.setTitulo(libro.titulo());
libroEntidad.setIdioma(libro.idiomas().get(0));
libroEntidad.setDescargas(libro.cantidadDeDescargas());
libroEntidad.setAutor(autor);

libroRepo.save(libroEntidad);


System.out.println(ANSI_GREEN + "Título: " + libro.titulo() + ANSI_RESET);
System.out.println(ANSI_GREEN + "Autor: " + libro.autores().get(0).name() + ANSI_RESET);
System.out.println(ANSI_GREEN + "Idioma: " + libro.idiomas().get(0) + ANSI_RESET);
System.out.println(ANSI_GREEN + "Descargas: " + libro.cantidadDeDescargas() + ANSI_RESET);

    }



}
