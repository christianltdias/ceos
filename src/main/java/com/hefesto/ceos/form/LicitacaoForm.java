package com.hefesto.ceos.form;

import com.hefesto.ceos.model.Licitacao;
import com.hefesto.ceos.model.Materia;
import com.hefesto.ceos.model.Usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class LicitacaoForm {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private Long materiaId;

    public LicitacaoForm(String nome, String descricao, BigDecimal valor, Long materiaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.materiaId = materiaId;
    }

    public LicitacaoForm() {
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public Licitacao toLicitacao(Materia materia, Usuario usuario) {
        Licitacao licitacao = new Licitacao(usuario, materia, valor, descricao);
        return licitacao;
    }
}
