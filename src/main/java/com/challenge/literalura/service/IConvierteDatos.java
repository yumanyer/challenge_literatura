package com.challenge.literalura.service;

public interface IConvierteDatos {
    //poniendo esto   <T> T le indico que estoy trabjando con tipos de datos genericos
    <T> T obtenerDatos( String json, Class <T> clase);
}
