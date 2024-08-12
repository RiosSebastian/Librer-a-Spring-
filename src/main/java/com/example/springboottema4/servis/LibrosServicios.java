package com.example.springboottema4.servis;

import com.example.springboottema4.entity.Libros;
import com.example.springboottema4.repository.LibrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibrosServicios extends LibrosRepository {

    default List<Libros> findByNombre_libro(String nombre_libro){
        return null;
    }

}
