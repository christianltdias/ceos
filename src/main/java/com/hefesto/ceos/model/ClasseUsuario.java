package com.hefesto.ceos.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLASSE_USUARIO")
public class ClasseUsuario {

    @Id
    @Column(name = "ID_CLASSE_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NM_CLASSE")
    private String nome;
    @Column(name = "DESCRICAO")
    private String descricao;
    @ManyToMany(mappedBy = "classesAcesso")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Permissao> permissoes = new ArrayList<>();


    public ClasseUsuario() {
    }

    public ClasseUsuario(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}
