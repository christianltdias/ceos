package com.hefesto.ceos.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hefesto.ceos.adapters.LicitacaoAdapter;
import com.hefesto.ceos.model.Licitacao;
import com.hefesto.ceos.repository.LicitacaoRepository;
import com.hefesto.ceos.service.LicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/licitacoes")
public class LicitacaoRest {

    @Autowired
    private LicitacaoService licitacaoService;

    @GetMapping
    private String bucaTodos(){
        List<Licitacao> licitacoes = licitacaoService.buscaTodos();
        Gson gson = new GsonBuilder().registerTypeAdapter(Licitacao.class, new LicitacaoAdapter()).create();
        return gson.toJson(licitacoes);
    }
}
