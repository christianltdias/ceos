package com.hefesto.ceos.form;

import com.hefesto.ceos.model.ClasseUsuario;
import com.hefesto.ceos.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioForm {

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @Email @NotBlank
    private String email;
    @NotBlank
    private String login;
    @NotBlank @Size(min = 8, max = 20)
    private String senha;
    @NotBlank @Size(min = 8, max = 20)
    private String confirmaSenha;
    @NotBlank
    private String classeAcesso;

    public UsuarioForm() {
    }

    public UsuarioForm(String nome, String sobrenome, String email, String login, String senha, String confirmaSenha,
                       String classeAcesso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        this.classeAcesso = classeAcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public String getClasseAcesso() {
        return classeAcesso;
    }

    public void setClasseAcesso(String classeAcesso) {
        this.classeAcesso = classeAcesso;
    }

    public Usuario toUsuario(ClasseUsuario classe) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);
        usuario.setLogin(login);
        usuario.setEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenha(encoder.encode(senha));
        usuario.setClasseUsuario(classe);

        return usuario;
    }
}
