package com.hefesto.ceos.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hefesto.ceos.adapters.UsuarioAdapter;
import com.hefesto.ceos.model.Usuario;
import com.hefesto.ceos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private String bucaTodos(){
        Gson gson = new GsonBuilder().registerTypeAdapter(Usuario.class, new UsuarioAdapter()).create();
        List<Usuario> usuarios = usuarioService.getTodos();
        return gson.toJson(usuarios);
    }
}
