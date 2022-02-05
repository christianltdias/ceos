package com.hefesto.ceos.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ID_CLASSE_USUARIO")
    private ClasseUsuario classeUsuario;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "SOBRENOME")
    private String sobrenome;
    @Column(name = "LOGIN", unique = true)
    private String login;
    @Column(name = "SENHA", unique = true)
    private String senha;
    @Column(name = "EMAIL", unique = true)
    private String email;
    @Column(name = "ATIVO")
    private boolean ativo = true;
    @Column(name = "DT_CADASTRO")
    private LocalDateTime dataCadastro;
    @Column(name = "DT_ATUALIZACAO_SENHA")
    private LocalDateTime dataAtuSenha;
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<Licitacao> licitacoes = new ArrayList<>();
    @ManyToMany(mappedBy = "alunos", fetch = FetchType.LAZY)
    private List<Licitacao> minhasLicitacoes = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String login, String senha, String email,
                   boolean ativo, LocalDateTime dataCadastro, LocalDateTime dataAtuSenha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
        this.dataAtuSenha = dataAtuSenha;
        this.sobrenome = sobrenome;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtuSenha() {
        return dataAtuSenha;
    }

    public void setDataAtuSenha(LocalDateTime dataAtuSenha) {
        this.dataAtuSenha = dataAtuSenha;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public ClasseUsuario getClasseUsuario() {
        return classeUsuario;
    }

    public void setClasseUsuario(ClasseUsuario classeUsuario) {
        this.classeUsuario = classeUsuario;
    }
}
