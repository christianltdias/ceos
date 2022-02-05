package com.hefesto.ceos.repository;

import com.hefesto.ceos.model.Licitacao;
import com.hefesto.ceos.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicitacaoRepository extends JpaRepository<Licitacao, Long> {
    List<Licitacao> findByMateria(Materia materia);
}
