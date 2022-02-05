package com.hefesto.ceos.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LICITACOES")
public class Licitacao {

    @Id
    @Column(name = "ID_LICITACAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ID_PROFESSOR")
    private Usuario professor;
    @ManyToOne
    @JoinColumn(name = "ID_MATERIA")
    private Materia materia;
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @Column(name = "FLG_ATIVO")
    private boolean ativo = true;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "DESCRICAO")
    private String descricao;
    @ManyToMany
    @JoinTable(
            name = "LICITACOES_USUARIOS",
            joinColumns = @JoinColumn(name = "ID_LICITACAO"),
            inverseJoinColumns = @JoinColumn(name = "ID_ALUNO")
    )
    private List<Usuario> alunos = new ArrayList<>();

    public Licitacao() {
    }

    public Licitacao(Usuario professor, Materia materia, LocalDateTime dataCriacao, boolean ativo, BigDecimal valor, String descricao) {
        this.professor = professor;
        this.materia = materia;
        this.dataCriacao = dataCriacao;
        this.ativo = ativo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Licitacao(Usuario professor, Materia materia, BigDecimal valor, String descricao) {
        this.professor = professor;
        this.materia = materia;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getProfessor() {
        return professor;
    }

    public void setProfessor(Usuario professor) {
        this.professor = professor;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Usuario> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Usuario> alunos) {
        this.alunos = alunos;
    }
}
