package com.hefesto.ceos.service;

import com.hefesto.ceos.model.Categoria;
import com.hefesto.ceos.model.Materia;
import com.hefesto.ceos.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<Materia> buscaTodos(){
        return materiaRepository.findAll();
    }

    public List<Materia> buscaPorCategoria(Categoria categoria){
        return materiaRepository.findByCategoria(categoria);
    }

    public Materia buscaPorId(Long idMateria) {
        Optional<Materia> materia = materiaRepository.findById(idMateria);
        if(materia.isPresent())
            return materia.get();
        return null;
    }

    public void salva(Materia materia) {
        materiaRepository.save(materia);
    }
}
