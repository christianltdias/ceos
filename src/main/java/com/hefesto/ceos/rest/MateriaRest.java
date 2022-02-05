package com.hefesto.ceos.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hefesto.ceos.adapters.MateriaAdapter;
import com.hefesto.ceos.model.Materia;
import com.hefesto.ceos.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/materias")
public class MateriaRest {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    private String bucaTodos(){
        List<Materia> materias = materiaService.buscaTodos();
        Gson gson = new GsonBuilder().registerTypeAdapter(Materia.class, new MateriaAdapter()).create();
        return gson.toJson(materias);
    }
}
