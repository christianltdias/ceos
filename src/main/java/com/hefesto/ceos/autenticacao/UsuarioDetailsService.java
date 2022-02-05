package com.hefesto.ceos.autenticacao;

import com.hefesto.ceos.model.Usuario;
import com.hefesto.ceos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscaUsuarioPorLogin(username);
        if(isNull(usuario))
            return null;
        UserDetails userDetails = new UsuarioDetails(usuario);
        return userDetails;
    }
}
