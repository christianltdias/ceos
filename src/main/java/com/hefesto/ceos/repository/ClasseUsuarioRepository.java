package com.hefesto.ceos.repository;

import com.hefesto.ceos.model.ClasseUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseUsuarioRepository extends JpaRepository<ClasseUsuario, Long> {
    ClasseUsuario findByNome(String nome);
}
