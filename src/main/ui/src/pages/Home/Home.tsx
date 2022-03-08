import homeImg from "../../assets/images/home.jpg";
import "./Home.scss";
import Button from "../../components/Button/SimpleButton/SimpleButton";
import { useNavigate } from "react-router-dom";

const Home = () => {
  const navigate = useNavigate();

  return (
    <div className="home_container container-fluid">
      <div className="container home_wrapper">
        <img src={homeImg} alt="Imagem do home" />
        <section>
          <h2 className="text-center">Ceos</h2>
          <h4 className="text-center mt-3">
            O seu buscador de serviços número 1.
          </h4>
          <div className="d-flex justify-content-center">
            <Button classExt="mt-3" fill={false} onClick={()=> navigate('login')} rounded={true}>
              Comece agora!
            </Button>
          </div>
        </section>
      </div>
      <div>
        <h1>Bem vindo</h1>
      </div>
    </div>
  );
};

export default Home;
