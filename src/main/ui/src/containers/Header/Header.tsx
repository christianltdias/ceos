import "./Header.scss";
import logo from "../../assets/icons/C.png";

const Header = () => {
  return (
    <>
      <div className="header shadow">
        <div className="d-flex flex-fill">
          <img src={logo} className="icon" alt="logo" />
          <div className="ml-3">
              <p className="align-middle p-0 m-0">Aqui é um Header</p></div>
        </div>
        <div className="flex-fill">Atalhos</div>
        <div className="flex-fill">Usuario</div>
      </div>
    </>
  );
};

export default Header;
