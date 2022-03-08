import { useEffect, useState } from "react";
import "./CategoriasLista.scss";
import { buscaTodasCategorias } from "../../services/CategoriaService";
import Categoria from "../../types/ICategoria";

const CategoriasLista = (): JSX.Element => {
  const [categorias, setCategorias] = useState<Categoria[]>([]);
  const [erro, setErro] = useState<string>("");

  useEffect(() => {
    buscaTodasCategorias()
      .then((res) => {
        setCategorias(categorias.concat(res));
      })
      .catch((err) => setErro(err));
  }, []);

  return (
    <div className="container p-3">
      <div className="row px-3">
        {categorias &&
          categorias.map(function (d, idx) {
            return (
              <div className="col-3 card" key={idx}>
                <h5 className="card-title">{d.nome}</h5>
                <p className="card-text">{d.descricao}</p>
              </div>
            );
          })}
      </div>
    </div>
  );
};

export default CategoriasLista;
