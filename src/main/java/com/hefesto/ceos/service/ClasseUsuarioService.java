package com.hefesto.ceos.service;

import com.hefesto.ceos.model.ClasseUsuario;
import com.hefesto.ceos.repository.ClasseUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseUsuarioService {

    @Autowired
    private ClasseUsuarioRepository classeUsuarioRepository;

    public List<ClasseUsuario> buscaTodos() {
        return classeUsuarioRepository.findAll();
    }

    public ClasseUsuario findByNome(String nome){
        return classeUsuarioRepository.findByNome(nome);
    }
}
