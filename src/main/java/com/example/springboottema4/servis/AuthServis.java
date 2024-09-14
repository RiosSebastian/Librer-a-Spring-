package com.example.springboottema4.servis;

import com.example.springboottema4.controladores.AuthReponse;
import com.example.springboottema4.controladores.LoginRequest;
import com.example.springboottema4.controladores.RegisterRequest;
import com.example.springboottema4.entity.Rol;
import com.example.springboottema4.entity.Usuario;
import com.example.springboottema4.servis.JwtServis;
import com.example.springboottema4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServis {
    private final JwtServis jwtServis;
    private final UserRepository userRepository;

    private AuthenticationManager authenticationManager;
    public AuthReponse Login(LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getContraseña()));
        UserDetails user = (UserDetails) userRepository.findbyUsername(request.getUsuario()).orElseThrow();
        String token = jwtServis.getToken(user);
        return AuthReponse.builder()
                .token(token)
                .build();
    }

    public AuthReponse Register(RegisterRequest request) {
        Usuario user = Usuario.builder()
                .usuario(request.getUsuario())
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .contraseña((request.getContraseña()))
                .city(request.getCity())
                .pais(request.getPais())
                .codigo_postal(request.getCodigo_postal())
                .telefono(request.getTelefono())
                .build();
        userRepository.save(user);
        return AuthReponse.builder()
                .token(jwtServis.getToken((UserDetails) user))
                .build();

    }
}
