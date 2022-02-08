import "./Header.scss";
import logo from "../../assets/icons/C.png";
import { useState } from "react";
import Button from "../../components/Button/SimpleButton/SimpleButton"

const Header = () => {
  const logado = true;
  const navItems: {
    text: string;
    link: string;
    key: number;
    logado: boolean;
  }[] = [
    { text: "Planos", link: "#", key: 0, logado: false },
    { text: "Matérias", link: "#", key: 1, logado: true },
    { text: "Sobre", link: "#", key: 2, logado: false },
  ];

  const [selected, setSelected] = useState(0);

  const userDetails = () => {
    if(logado){
      return (
      <div className="d-flex h-100 justify-content-end align-items-center">
        <Button fill={false} classExt="rounded">Sign in</Button>
        <Button fill={true} classExt="mx-3 rounded">Sign up</Button>
      </div>)
    }
    else {
      return (
      <>
        
      </>)
    }
  }

  return (
    <>
      <div className="header shadow row">
        <div className="d-flex col-3 align-items-center">
          <img src={logo} className="icon" alt="logo" />
          <div className="d-flex justify-content-center">
            <p className="logo_text">Ceos</p>
          </div>
        </div>
        <nav className="nav nav-header col-6 justify-content-center d-flex align-items-center">
          {navItems.map(
            (item) =>
              (logado ||
              logado === item.logado) && (
                  <a
                    className={`nav-link ${selected == item.key ? "active" : ""}`}
                    onClick={() => setSelected(item.key)}
                    aria-current="page"
                    href={item.link}
                  >
                    {item.text}
                  </a>
              )
          )}
        </nav>
        <div className="col-3 user_details">
          {userDetails()}
        </div>
      </div>
    </>
  );
};

export default Header;
