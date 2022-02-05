package com.hefesto.ceos.service;

import com.hefesto.ceos.model.Permissao;
import com.hefesto.ceos.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> buscaTodos(){
        return permissaoRepository.findAll();
    }
}
