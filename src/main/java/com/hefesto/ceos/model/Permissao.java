package com.hefesto.ceos.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PERMISSOES")
public class Permissao {

    @Id
    @Column(name = "ID_PERMISSAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME", nullable = false, unique = true)
    private String nome;
    @Column(name = "DESCRICAO")
    private String descricao;
    @ManyToMany
    @JoinTable(
            name = "CLASSE_ACESSO_PERMISSOES",
            joinColumns = @JoinColumn(name = "ID_PERMISSAO"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLASSE_ACESSO"))
    private List<ClasseUsuario> classesAcesso = new ArrayList<>();;

    public Permissao() {
    }

    public Permissao(String nome, String descricao) {
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

    public List<ClasseUsuario> getClassesAcesso() {
        return classesAcesso;
    }

    public void setClassesAcesso(List<ClasseUsuario> classesAcesso) {
        this.classesAcesso = classesAcesso;
    }
}
