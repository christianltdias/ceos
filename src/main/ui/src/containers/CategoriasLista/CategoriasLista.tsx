import { useEffect, useState } from "react";
import "./CategoriasLista.scss";
import CategoriaService from "../../services/CategoriaService";
import Categoria from "../../types/ICategoria"
import Token from "../../types/Token"

const categoriaService: CategoriaService = new CategoriaService();

function getToken(): string | null {
    const tokenString: string | null = sessionStorage.getItem('token');
    
    if(tokenString){
        const userToken: Token = JSON.parse(tokenString ? tokenString : "");
        return userToken?.tipo.concat(" ", userToken.token);
    }
  
    return tokenString;
  }

const CategoriasLista = (): JSX.Element => {
  const [categorias, setCategorias] = useState<Categoria[]>([]);
  const [erro, setErro] = useState<string>("");

  useEffect(() => {
    categoriaService
      .buscaTodasCategorias()
      .then((res) => {
        setCategorias(categorias.concat(res));
      })
      .catch((err) => setErro(err));
  }, []);

  return (
    <div className="d-flex justify-content-center align-items-center">
        <p>{getToken()}</p>
      <div className="shadow">
        {categorias &&
          categorias.map(function (d, idx) {
            return (
              <div className="card mt-5" key={idx}>
                <div className="card-header">{d.id}</div>
                <img
                  src={d.urlImagem}
                  className="card-img-top card-img"
                  alt="..."
                ></img>
                <div className="card-body">
                  <h5 className="card-title">{d.nome}</h5>
                  <p className="card-text">{d.descricao}</p>
                  <ul>
                    {d.materias.map((item, idx) => (
                      <li key={idx}>{item}</li>
                    ))}
                  </ul>
                  <a href={d.urlImagem} className="btn btn-primary">
                    Ir para página
                  </a>
                </div>
              </div>
            );
          })}
      </div>
      {erro && <p>Ocorreu um erro ao buscar categorias</p>}
    </div>
  );
};

export default CategoriasLista;
