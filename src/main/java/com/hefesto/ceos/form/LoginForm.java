package com.hefesto.ceos.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

    @NotEmpty @NotNull
    private String login;
    @NotEmpty @NotNull
    private String senha;
    

    public LoginForm(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public UsernamePasswordAuthenticationToken converter() {
        return  new UsernamePasswordAuthenticationToken(login, senha);
    }

}
