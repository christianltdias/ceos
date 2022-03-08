package com.hefesto.ceos.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefesto.ceos.autenticacao.UsuarioDetails;
import com.hefesto.ceos.model.Usuario;
import com.hefesto.ceos.service.UsuarioService;
import com.hefesto.ceos.utils.UsuarioUtil;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


import static java.util.Objects.isNull;
import static org.apache.logging.log4j.util.Strings.isEmpty;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter{

    private TokenService tokenService;
    private UsuarioService usuarioService;

    public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioService usuarioService) {
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValido(token);
        if(valido)
            autenticaCliente(token);
        setHeaders(request, response);
        filterChain.doFilter(request, response);
    }

    private void autenticaCliente(String token) {
        Long idUsuario = tokenService.getIdUsuario(token);
        Usuario usuario = usuarioService.getById(idUsuario);
        UsuarioUtil.getInstance().setUsuarioDetails(new UsuarioDetails(usuario));
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getClasseUsuario().getPermissoes());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(isNull(token) || isEmpty(token) || !token.startsWith("Bearer "))
            return null;

        return token.substring(7, token.length());
    }

    private void setHeaders(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
    }
    
}
