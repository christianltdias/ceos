package com.hefesto.ceos.security;

import java.util.Date;

import com.hefesto.ceos.autenticacao.UsuarioDetails;
import com.hefesto.ceos.model.Usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
    
    @Value("${ceos.jwt.expiration}")
    private String expiration;
    @Value("${ceos.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Usuario usuario = ((UsuarioDetails) authentication.getPrincipal()).getUsuario();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("Ceos Project")
                .setSubject(usuario.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValido(String token) {
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        try{
            Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return  Long.parseLong(body.getSubject());
        }catch (Exception e){
            return null;
        }
    }
    
}
