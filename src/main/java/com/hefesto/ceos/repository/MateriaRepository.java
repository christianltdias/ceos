package com.hefesto.ceos.repository;

import com.hefesto.ceos.model.Categoria;
import com.hefesto.ceos.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

    List<Materia> findByCategoria(Categoria categoria);
}
