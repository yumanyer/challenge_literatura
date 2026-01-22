package com.challenge.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
    Integer id,

    @JsonAlias("title")
    String titulo,

    @JsonAlias("authors")
    List<DatosAutor> autores,

    @JsonAlias("languages")
    List<String> idiomas,

    @JsonAlias("download_count")
    Integer cantidadDeDescargas
) {}
