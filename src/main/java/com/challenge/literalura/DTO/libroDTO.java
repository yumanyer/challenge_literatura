package com.challenge.literalura.DTO;

public record libroDTO(
    Long id,
    String titulo,
    String autor,
    int añoDeNacimiento,
    int añoDeMuerte,
    String idioma,
    int cantidadDeDescargas
) {

}
