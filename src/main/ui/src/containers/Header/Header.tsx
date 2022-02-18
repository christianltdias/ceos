import "./Header.scss";
import logo from "../../assets/icons/C.png";
import Button from "../../components/Button/SimpleButton/SimpleButton";
import { Link, useNavigate, useLocation } from "react-router-dom";
import { useEffect, useState } from "react";
import { minhasInfo } from "../../services/AutenticacaoService";
import Token from "../../types/Token";
import Usuario from "../../types/Usuario";
import useToken from "../../hooks/tokenHook"

interface Props {
  logado: boolean;
  logout: (token: Token | null) => Promise<void>;
}

const Header = ({logado, logout}: Props) => {
  const navigate = useNavigate();
  const { pathname } = useLocation();

  const [usuario, setUsuario] = useState<Usuario>();

  const navItems: {
    text: string;
    link: string;
    isLogado: boolean;
  }[] = [
    { text: "Planos", link: "planos", isLogado: false },
    { text: "Matérias", link: "materias", isLogado: true },
    { text: "Categorias", link: "categorias", isLogado: true },
    { text: "Sobre", link: "sobre", isLogado: false },
  ];

  useEffect(() => {
    console.log("header")
    if (logado) {
      minhasInfo().then((usuario) => {
        setUsuario(usuario);
      });
    }
  }, [logado]);

  const userDetails = () => {
    if (!logado) {
      return (
        <div className="d-flex h-100 justify-content-end align-items-center">
          <Button
            fill={false}
            classExt="rounded"
            onClick={() => navigate("/login")}
          >
            Entrar
          </Button>
          <Button
            fill={true}
            classExt="mx-3 rounded"
            onClick={() => navigate("/signup")}
          >
            Cadastrar
          </Button>
        </div>
      );
    } else {
      return (
        <div className="d-flex h-100 justify-content-end align-items-center">
          <div className="user_info_wrapper">
            <button>
              <i className="bi bi-person-fill"></i>
              {usuario?.nome}
            </button>
            <button onClick={() => logout(null)}>
              <i className="bi bi-arrow-up-right-circle-fill"></i>
            </button>
          </div>
        </div>
      );
    }
  };

  return (
    <header className="header shadow row">
      <div className="col-3">
        <Link to="/" className="d-flex align-items-center">
          <img src={logo} className="icon" alt="logo" />
          <div className="d-flex justify-content-center">
            <p className="logo_text">Ceos</p>
          </div>
        </Link>
      </div>
      <nav className="nav nav-header col-6 justify-content-center d-flex align-items-center">
        {navItems.map(
          (item, idx) =>
            (logado || logado === item.isLogado) && (
              <Link
                className={`nav-link ${
                  item.link == pathname.split("/")[1] ? "active" : ""
                }`}
                aria-current="page"
                to={item.link}
                key={idx}
              >
                {item.text}
              </Link>
            )
        )}
      </nav>
      <div className="col-3 user_details">{userDetails()}</div>
    </header>
  );
};

export default Header;
