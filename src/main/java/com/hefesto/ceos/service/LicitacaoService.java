package com.hefesto.ceos.service;

import com.hefesto.ceos.model.Licitacao;
import com.hefesto.ceos.model.Materia;
import com.hefesto.ceos.repository.LicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicitacaoService {

    @Autowired
    private LicitacaoRepository licitacaoRepository;

    public List<Licitacao> buscaTodos(){
        return licitacaoRepository.findAll();
    }

    public List<Licitacao> buscaPorMateria(Materia materia) {
        return licitacaoRepository.findByMateria(materia);
    }

    public void salva(Licitacao licitacao) {
        licitacaoRepository.save(licitacao);
    }
}
