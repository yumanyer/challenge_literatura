package com.challenge.literalura.model;


import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer añioNacimiento;
    private Integer añioMuerte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAñioNacimiento() {
        return añioNacimiento;
    }

    public void setAñioNacimiento(Integer añioNacimiento) {
        this.añioNacimiento = añioNacimiento;
    }

    public Integer getAñioMuerte() {
        return añioMuerte;
    }

    public void setAñioMuerte(Integer añioMuerte) {
        this.añioMuerte = añioMuerte;
    }
}
