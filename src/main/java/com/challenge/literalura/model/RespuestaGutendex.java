package com.challenge.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespuestaGutendex(
        @JsonAlias("count") Integer count,
        @JsonAlias("results") List<DatosLibro> results
) {
}
