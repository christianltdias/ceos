package com.hefesto.ceos.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hefesto.ceos.adapters.ClasseUsuarioAdapter;
import com.hefesto.ceos.model.ClasseUsuario;
import com.hefesto.ceos.service.ClasseUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/classes")
public class ClasseUsuarioRest {

    @Autowired
    private ClasseUsuarioService classeUsuarioService;

    @GetMapping
    private String bucaTodos(){
        List<ClasseUsuario> classes = classeUsuarioService.buscaTodos();
        Gson gson = new GsonBuilder().registerTypeAdapter(ClasseUsuario.class, new ClasseUsuarioAdapter()).create();
        return gson.toJson(classes);
    }
}
