package com.example.springboottema4.repository;

import com.example.springboottema4.entity.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Long> {
    List<Libros> findByNombre_libro(String nombre_libro);

   /* spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url= jdbc:mysql://localhost:3306/biblioteca
    spring.datasource.username=root
    spring.datasuorce.password=conejoloco07ñadu2001ch4ri7o%l0ki09
    spring.jpa.hibernate.ddl-auto= update
    spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL57Dialect
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true*/
}
