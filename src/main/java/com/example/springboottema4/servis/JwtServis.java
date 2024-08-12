package com.example.springboottema4.servis;

import com.example.springboottema4.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.antlr.v4.runtime.Token;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtServis {
    private static final String Secret_Ket="55646804806F50250465408042E120231214147642126465";
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(),user);
    }

    private String getToken(HashMap<String,Object> extraClaims, UserDetails user) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getKey(), SignatureAlgorithm.ES256)
                .compact();

    }

    private Key getKey(){
        byte[] keybyte = Decoders.BASE64.decode(Secret_Ket);
        return Keys.hmacShaKeyFor(keybyte);
    }

    public String getUsernameFromToken(String token) {
        return getClaims(token, Claims::getSubject);
    }

    public boolean IsTokenNail(String token, UserDetails userdetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userdetails.getUsername())&& isTokenExpiration(token));
    }

    private Claims getAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaims(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token){
        return getClaims(token, Claims::getExpiration);
    }

    private boolean isTokenExpiration(String token){
        return getExpiration(token).before(new Date());
    }
}
