package com.hefesto.ceos.utils;

import com.hefesto.ceos.autenticacao.UsuarioDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public class UsuarioUtil {

    private UsuarioDetails usuarioDetails;

    private static UsuarioUtil instance;

    public static UsuarioUtil getInstance() {
        if (instance == null)
            instance = new UsuarioUtil();
        return instance;
    }

    public UsuarioUtil() {
        if (SecurityContextHolder.getContext() != null &&
                SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null &&
                SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UsuarioDetails) {
                    UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    this.usuarioDetails = usuarioDetails;
        }
    }

    public UsuarioDetails getUsuarioDetails() {
        return usuarioDetails;
    }

    public void setUsuarioDetails(UsuarioDetails usuarioDetails) {
        this.usuarioDetails = usuarioDetails;
    }
}
