package com.hefesto.ceos.service;

import com.hefesto.ceos.model.Usuario;
import com.hefesto.ceos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario buscaUsuarioPorId(Long id){
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(id);
        if(!usuarioBuscado.isPresent())
            return null;
        return usuarioBuscado.get();
    }

    public Usuario buscaUsuarioPorLogin(String login){
        return usuarioRepository.findByLogin(login);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario getById(Long id){
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isPresent())
            return optUsuario.get();
        return null;
    }
}
