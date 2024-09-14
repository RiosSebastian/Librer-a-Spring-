package com.example.springboottema4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "usuarios", uniqueConstraints = {@UniqueConstraint(columnNames= {"usuario"})})
public class Usuario  {
    @Id
    @GeneratedValue
    Integer id;
   @Column(nullable = false)
    String usuario;
    String contraseña;
    String nombre;
    String apellido;
    String city;
    String pais;
    String codigo_postal;
    String telefono;


}
