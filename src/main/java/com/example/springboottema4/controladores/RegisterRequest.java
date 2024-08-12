package com.example.springboottema4.controladores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String usuario;
    String contraseña;
    String nombre;
    String apellido;
    String city;
    String pais;
    String codigo_postal;
    String telefono;
}
