import Button from "../../components/Button/SimpleButton/SimpleButton";
import "./Login.scss";
import React, { useState } from "react";
import { logar } from "../../services/AutenticacaoService";
import { useNavigate, Link } from "react-router-dom";

interface Props {
  setUsuario: any;
  logado: boolean;
}

const Login = ({ setUsuario, logado }: Props) => {
  const [login, setLogin] = useState("");
  const [senha, setSenha] = useState("");
  const [erro, setErro] = useState(false);
  const navigate = useNavigate();
  const versao = "1.0.0";

  const submitForm = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const data = { login, senha };
    setErro(false);
    logar(data)
      .then(async (response) => {
        await setUsuario(response);
        navigate("/categorias", { replace: true });
      })
      .catch((err) => {
        setErro(true);
      });
  };
  console.log("login " + logado);

  if (logado) navigate("/", { replace: true });

  return (
    <div className="login-pg h-100 d-flex justify-content-center align-items-center">
      <div className="col-6 d-flex flex-column justify-content-center align-items-center login-left-wrapper">
        <h3>Ceos</h3>
        <p className="mt-3">Encontre o que você procura aqui</p>
        <p className="versao">{versao}</p>
        <Button classExt="mt-5" rounded={true}>
          <Link to="/signup">Crie sua conta</Link>
        </Button>
      </div>
      <form
        className="col-6 form-horizontal h-100 d-flex flex-column align-items-center justify-content-center"
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
          classExt="w-50 mt-5 mb-5"
          fill={false}
          tipo="submit"
          rounded={true}
        >
          Login
        </Button>
      </form>
    </div>
  );
};

export default Login;
