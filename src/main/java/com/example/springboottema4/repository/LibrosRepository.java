package com.example.springboottema4.repository;

import com.example.springboottema4.entity.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Long> {
    List<Libros> findByNombre_libro(String nombre_libro);
}
