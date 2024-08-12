package com.example.springboottema4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_libro;
    private  String nombre_autor;
    private  String numero_paginas;
    private  String sinopcis;



    public Libros(Long id, String nombre_libro, String nombre_autor, String numero_paginas, String sinopcis) {
        this.id = id;
        this.nombre_libro = nombre_libro;
        this.nombre_autor = nombre_autor;
        this.numero_paginas = numero_paginas;
        this.sinopcis = sinopcis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(String numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    public String getSinopcis() {
        return sinopcis;
    }

    public void setSinopcis(String sinopcis) {
        this.sinopcis = sinopcis;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "id=" + id +
                ", nombre_libro='" + nombre_libro + '\'' +
                ", nombre_autor='" + nombre_autor + '\'' +
                ", numero_paginas='" + numero_paginas + '\'' +
                ", sinopcis='" + sinopcis + '\'' +
                '}';
    }
}
