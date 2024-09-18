package com.example.springboottema4.repository;

import com.example.springboottema4.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByusuario(String usuario);
}
