package com.hefesto.ceos.service;

import com.hefesto.ceos.model.Categoria;
import com.hefesto.ceos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscaTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria buscaPorId(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent())
            return categoria.get();
        return null;
    }

    public void salva(Categoria categoria){
        categoriaRepository.save(categoria);
    }
}
