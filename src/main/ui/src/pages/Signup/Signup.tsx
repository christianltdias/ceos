import Button from "../../components/Button/SimpleButton/SimpleButton";
import { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import { cadastrar } from "../../services/UsuarioService";
import Validation from "../../providers/Validation";

const defaultValidation = {
  nome: false,
  sobrenome: false,
  login: false,
  email: false,
  senha: false,
  senhasIguais: false,
};

const Signup = () => {
  const [nome, setNome] = useState("");
  const [sobrenome, setSobrenome] = useState("");
  const [login, setLogin] = useState("");
  const [email, setEmail] = useState("");
  const [dataNascimento, setDataNascimento] = useState("");
  const [senha, setSenha] = useState("");
  const [confirmarSenha, setConfirmarSenha] = useState("");

  const { isEmpty, inLength, matches } = useContext(Validation);

  const [erro, setErro] = useState(defaultValidation);
  const navigate = useNavigate();

  const validaCampos = (): boolean => {
    var validForm = true;
    const erros = {...defaultValidation};

    if (isEmpty(nome)) {
      erros.nome = true;
      validForm = false;
    }
    if (isEmpty(sobrenome)) {
      erros.sobrenome = true;
      validForm = false;
    }
    if (isEmpty(login)) {
      erros.login = true;
      validForm = false;
    }
    if (isEmpty(email)) {
      erros.email = true;
      validForm = false;
    }
    if (!inLength(senha, 8) || isEmpty(senha)) {
      erros.senha = true;
      validForm = false;
    }
    if (!matches(senha, confirmarSenha)) {
      erros.senhasIguais = true;
      validForm = false;
    }
    console.log(defaultValidation)
    setErro(erros);
    return validForm;
  };

  const submitForm = (e: React.FormEvent<HTMLFormElement>): void => {
    e.preventDefault();

    if (validaCampos()) {
      const data = {
        nome,
        sobrenome,
        email,
        login,
        senha,
        dataNascimento,
      };

      cadastrar(data)
        .then((response) => {
          navigate("/login");
        })
        .catch((error) => console.log(error));
    }
  };

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
            className={`form-control ${erro.nome ? "is-invalid" : ""}`}
            id="signupnome"
            placeholder="Nome"
          />
          <label htmlFor="signupnome">Nome*</label>
          <div className="invalid-feedback">campo obrigatório</div>
        </div>
        <div className="form-floating mb-3 w-75">
          <input
            type="text"
            value={sobrenome}
            onChange={(e) => setSobrenome(e.target.value)}
            className={`form-control ${erro.sobrenome ? "is-invalid" : ""}`}
            id="signupsobrenome"
            placeholder="Sobrenome"
          />
          <label htmlFor="signupsobrenome">Sobrenome*</label>
          <div className="invalid-feedback">campo obrigatório</div>
        </div>
        <div className="form-floating mb-3 w-75">
          <input
            type="text"
            value={login}
            onChange={(e) => setLogin(e.target.value)}
            className={`form-control ${erro.login ? "is-invalid" : ""}`}
            id="signuplogin"
            placeholder="Login"
          />
          <label htmlFor="signuplogin">Login*</label>
          <div className="invalid-feedback">campo obrigatório</div>
        </div>
        <div className="form-floating mb-3 w-75">
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className={`form-control ${erro.email ? "is-invalid" : ""}`}
            id="signupemail"
            placeholder="example@example.com"
          />
          <label htmlFor="signupemail">E-mail*</label>
          <div className="invalid-feedback">campo obrigatório</div>
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
            className={`form-control ${erro.senha ? "is-invalid" : ""}`}
            id="signuppass"
            placeholder="senha"
          />
          <label htmlFor="signuppass">Senha*</label>
          <div className="invalid-feedback">campo obrigatório</div>
        </div>
        <div className="form-floating w-75 mt-4">
          <input
            type="password"
            value={confirmarSenha}
            onChange={(e) => setConfirmarSenha(e.target.value)}
            className={`form-control ${erro.senhasIguais ? "is-invalid" : ""}`}
            id="signupconfirmpass"
            placeholder="confirmar senha"
          />
          <label htmlFor="signupconfirmpass">Confirme sua senha*</label>
          <div className="invalid-feedback">senhas não iguais</div>
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
        <Button
          classExt="mt-5"
          rounded={true}
          onClick={() => navigate("/login")}
        >
          Entrar
        </Button>
      </div>
    </div>
  );
};

export default Signup;
