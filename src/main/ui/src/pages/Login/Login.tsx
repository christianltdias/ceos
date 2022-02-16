import Button from "../../components/Button/SimpleButton/SimpleButton";
import "./Login.scss";
import React, { useState } from "react";
import AutenticacaoService from "../../services/AutenticacaoService";
import {useNavigate} from 'react-router-dom'

const autenticacaoService = new AutenticacaoService();

const Login = (setToken: any) => {
  const [login, setLogin] = useState("");
  const [senha, setSenha] = useState("");
  const [erro, setErro] = useState(false);
  const navigate = useNavigate();

  const submitForm = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const data = { login, senha };
    setErro(false);
    autenticacaoService
      .logar(data)
      .then((response) => {
        setTimeout(() => { navigate('/categorias', {replace: true});}, 2000)
      })
      .catch((err) => {
        setErro(true);
      });
  };

  return (
    <div className="login-pg h-100 d-flex justify-content-center align-items-center">
      <div className="card shadow">
        <div className="card-body">
          <form
            className="form-horizontal h-100 d-flex flex-column align-items-center justify-content-center"
            onSubmit={(e) => submitForm(e)}
          >
            <div className="form-floating mb-3 w-75">
              <input
                type="text"
                value={login}
                onChange={(e) => setLogin(e.target.value)}
                className="form-control"
                id="floatingInput"
                placeholder="name@example.com"
              />
              <label htmlFor="floatingInput">Login</label>
            </div>
            <div className="form-floating w-75 mt-4">
              <input
                type="password"
                value={senha}
                onChange={(e) => setSenha(e.target.value)}
                className="form-control"
                id="floatingPassword"
                placeholder="Password"
              />
              <label htmlFor="floatingPassword">Senha</label>
            </div>
            <Button
              classExt="btn btn-primary w-50 mt-5 mb-5"
              fill={false}
              tipo="submit"
            >
              Login
            </Button>
            <p className="mt-5">
              <a href="#" className="link-none text-contrast">
                Ainda não tem uma conta? Cadastre-se agora
              </a>
            </p>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
