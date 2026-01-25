package com.challenge.literalura.model;


import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer año_Nacimiento;
    private Integer año_Muerte;

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

    public Integer getAño_Nacimiento() {
        return año_Nacimiento;
    }

    public void setAño_Nacimiento(Integer año_Nacimiento) {
        this.año_Nacimiento = año_Nacimiento;
    }

    public Integer getAño_Muerte() {
        return año_Muerte;
    }

    public void setAño_Muerte(Integer año_Muerte) {
        this.año_Muerte = año_Muerte;
    }
}
