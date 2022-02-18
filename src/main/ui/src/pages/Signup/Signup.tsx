import Button from "../../components/Button/SimpleButton/SimpleButton";
import { useState } from "react";
import { Link } from "react-router-dom";

const submitForm = (e: React.FormEvent<HTMLFormElement>) => {
  e.preventDefault();
  console.log("olá");
};

const Signup = () => {
  const [nome, setNome] = useState("");
  const [sobrenome, setSobrenome] = useState("");
  const [email, setEmail] = useState("");
  const [dataNascimento, setDataNascimento] = useState("");
  const [senha, setSenha] = useState("");
  const [confirmarSenha, setConfirmarSenha] = useState("");

  return (
    <div className="login-pg h-100 d-flex justify-content-center align-items-center">
      <form
        className="col-6 form-horizontal h-100 d-flex flex-column align-items-center justify-content-center"
        onSubmit={(e) => submitForm(e)}
      >
        <div className="form-floating mb-3 w-75">
          <input
            type="text"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            className="form-control"
            id="signupnome"
            placeholder="Nome"
          />
          <label htmlFor="signupnome">Nome</label>
        </div>
        <div className="form-floating mb-3 w-75">
          <input
            type="text"
            value={sobrenome}
            onChange={(e) => setSobrenome(e.target.value)}
            className="form-control"
            id="signupsobrenome"
            placeholder="Sobrenome"
          />
          <label htmlFor="signupsobrenome">Sobrenome</label>
        </div>
        <div className="form-floating mb-3 w-75">
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="form-control"
            id="signupemail"
            placeholder="example@example.com"
          />
          <label htmlFor="signupemail">E-mail</label>
        </div>
        <div className="form-floating mb-3 w-75">
          <input
            type="date"
            value={dataNascimento}
            onChange={(e) => setDataNascimento(e.target.value)}
            className="form-control"
            id="signupdata"
            placeholder="dd/MM/yyyy"
          />
          <label htmlFor="signupdata">Data Nascimento</label>
        </div>
        <div className="form-floating w-75 mt-4">
          <input
            type="password"
            value={senha}
            onChange={(e) => setSenha(e.target.value)}
            className="form-control"
            id="signuppass"
            placeholder="senha"
          />
          <label htmlFor="signuppass">Senha</label>
        </div>
        <div className="form-floating w-75 mt-4">
          <input
            type="password"
            value={confirmarSenha}
            onChange={(e) => setConfirmarSenha(e.target.value)}
            className="form-control"
            id="signupconfirmpass"
            placeholder="confirmar senha"
          />
          <label htmlFor="signupconfirmpass">Confirme sua senha</label>
        </div>
        <Button
          classExt="w-50 mt-5 mb-5"
          fill={false}
          tipo="submit"
          rounded={true}
        >
          Cadastrar
        </Button>
      </form>
      <div className="col-6 d-flex flex-column justify-content-center align-items-center login-left-wrapper">
        <h3>Ceos</h3>
        <p className="mt-3">Já possui uma conta?</p>
        <Button classExt="mt-5" rounded={true}>
          <Link to="/login">Entrar</Link>
        </Button>
      </div>
    </div>
  );
};

export default Signup;
