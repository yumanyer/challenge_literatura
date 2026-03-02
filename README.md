[challenge_literatura.md](https://github.com/user-attachments/files/25685596/challenge_literatura.md)
# challenge_literatura

[![Made by DigitalPro](https://img.shields.io/badge/Made%20by-DigitalPro-blue)](https://digitalpro.dev)
![Version](https://img.shields.io/badge/Version-1.0.2-blue)
![Tecnología](https://img.shields.io/badge/Tecnología-Java-red)
![Framework](https://img.shields.io/badge/Framework-Spring_Boot-green)
![Base de Datos](https://img.shields.io/badge/Base_de_Datos-PostgreSQL-blue)
![ORM](https://img.shields.io/badge/ORM-Spring_Data_JPA-purple)
![API](https://img.shields.io/badge/API-Gutendex-lightgrey)

## Descripción del Sistema

**challenge_literatura** es una aplicación desarrollada con Spring Boot que permite interactuar con la API de Gutendex para buscar y gestionar información sobre libros y autores. El sistema está diseñado para consumir datos de la API, persistirlos en una base de datos PostgreSQL utilizando Spring Data JPA, y ofrecer funcionalidades para explorar la literatura. Este proyecto es parte de un desafío del programa ONE Next Education, enfocado en la integración de APIs y la persistencia de datos.

## Características Principales

*   **Integración con Gutendex API:** Permite buscar libros y autores a través de la API de Gutendex.
*   **Persistencia de Datos:** Almacena la información de libros y autores en una base de datos PostgreSQL.
*   **Gestión de Libros y Autores:** Funcionalidades para consultar, guardar y organizar datos literarios.
*   **Desarrollo con Spring Boot:** Utiliza el framework Spring Boot para una rápida configuración y desarrollo de aplicaciones Java.

## Tecnologías Utilizadas

*   **Java 17**: Lenguaje de programación.
*   **Spring Boot**: Framework para el desarrollo de aplicaciones Java.
*   **Spring Data JPA**: Para la persistencia de datos y la interacción con la base de datos.
*   **PostgreSQL**: Base de datos relacional.
*   **Maven**: Herramienta de gestión de proyectos.
*   **Jackson Databind**: Librería para el manejo de JSON.
*   **Gutendex API**: API pública para acceder a información de libros.

## Cómo Ejecutar el Sistema

Para poner en marcha este proyecto, sigue los siguientes pasos:

1.  **Clonar el Repositorio:**
    ```bash
    git clone https://github.com/yumanyer/challenge_literatura.git
    cd challenge_literatura
    ```

2.  **Configurar la Base de Datos PostgreSQL:**
    Asegúrate de tener una instancia de PostgreSQL en ejecución. Crea una base de datos y configura las credenciales en el archivo `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_tu_base_de_datos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3.  **Compilar y Ejecutar con Maven:**
    Asegúrate de tener Maven y Java 17 instalados. Luego, compila y ejecuta la aplicación:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4.  **Acceder a la Aplicación:**
    Una vez que la aplicación esté en ejecución, podrás interactuar con ella a través de la consola o mediante las APIs que exponga (si las hubiera).
