package com.hefesto.ceos.form;

import com.hefesto.ceos.model.Categoria;
import com.hefesto.ceos.model.Materia;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MateriaForm {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Long categoriaId;

    public MateriaForm(String nome, String descricao, Long categoriaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoriaId = categoriaId;
    }

    public MateriaForm() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Materia toMateria(Categoria categoria) {
        Materia materia = new Materia(nome, descricao, categoria);
        return materia;
    }
}
