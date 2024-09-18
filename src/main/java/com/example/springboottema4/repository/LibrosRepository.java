package com.example.springboottema4.repository;


import com.example.springboottema4.entity.Libros;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LibrosRepository  extends CrudRepository<Libros, Long> {

    //Libros findByNombre_libro(String nombre_libro);

}
