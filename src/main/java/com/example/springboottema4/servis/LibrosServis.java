package com.example.springboottema4.servis;

import com.example.springboottema4.entity.Libros;

import java.util.List;

public interface LibrosServis {
    Libros guardarLibros(Libros nombre_libro);

    List<Libros> BuscarListaDeLibros();
    List<Libros> BuscarListaDeLibros(Long id);

    Libros actualizarLibros(Libros libros, Long id);

    void deletelibrosByid(long id);

    boolean existsById(Long id);
}
