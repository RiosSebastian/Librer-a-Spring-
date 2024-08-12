package com.example.springboottema4.controladores;

import com.example.springboottema4.servis.AuthServis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthControles {

    private final AuthServis authservis;

    @PostMapping(value = "login")
    public ResponseEntity <AuthReponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authservis.Login(request));
    }

    @PostMapping(value = "registro")
    public  ResponseEntity <AuthReponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authservis.Register(request));
    }
}
