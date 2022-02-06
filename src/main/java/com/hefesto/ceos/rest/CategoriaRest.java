package com.hefesto.ceos.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hefesto.ceos.adapters.CategoriaAdapter;
import com.hefesto.ceos.adapters.UsuarioAdapter;
import com.hefesto.ceos.model.Categoria;
import com.hefesto.ceos.model.Usuario;
import com.hefesto.ceos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoriaRest {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    private String bucaTodos(){
        Gson gson = new GsonBuilder().registerTypeAdapter(Categoria.class, new CategoriaAdapter()).create();
        List<Categoria> categorias = categoriaService.buscaTodos();
        return gson.toJson(categorias);
    }

    @GetMapping("/{idCategoria}")
    private String buscaPorId(@PathVariable Long idCategoria) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Categoria.class, new CategoriaAdapter()).create();
        Categoria categoria = categoriaService.buscaPorId(idCategoria);
        return gson.toJson(categoria);
    }
}
