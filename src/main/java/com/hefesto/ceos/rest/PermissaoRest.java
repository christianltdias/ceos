package com.hefesto.ceos.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hefesto.ceos.adapters.PermissaoAdapter;
import com.hefesto.ceos.model.Permissao;
import com.hefesto.ceos.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("permissoes")
public class PermissaoRest {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping
    private String bucaTodos(){
        Gson gson = new GsonBuilder().registerTypeAdapter(Permissao.class, new PermissaoAdapter()).create();
        List<Permissao> permissoes = permissaoService.buscaTodos();
        return gson.toJson(permissoes);
    }
}
