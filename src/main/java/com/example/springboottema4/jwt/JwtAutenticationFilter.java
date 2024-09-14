package com.example.springboottema4.jwt;

import com.example.springboottema4.servis.JwtServis;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
//@RequiredArgsConstructor
public class JwtAutenticationFilter extends OncePerRequestFilter {


    private final JwtServis jwtServis;
    private final UserDetailsService userDetailsService;

    public JwtAutenticationFilter(JwtServis jwtServis, UserDetailsService userDetailsService) {
        this.jwtServis = jwtServis;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String token = getTokenFromRequest(request);
        final String username;
        
        if (token == null){
            filterChain.doFilter(request, response);
            return;
        }
       username=jwtServis.getUsernameFromToken(token);

        if(username!= null && SecurityContextHolder.getContext().getAuthentication()== null){
            UserDetails userdetails= userDetailsService.loadUserByUsername(username);
            if(jwtServis.IsTokenNail(token,userdetails)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userdetails,
                        null,
                        userdetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
        
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeder=request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(authHeder) && authHeder.startsWith("Bearer ")){
            return  authHeder.substring(7);
        }
        return null;
    }
}
