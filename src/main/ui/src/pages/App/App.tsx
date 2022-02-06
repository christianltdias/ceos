import React, { useState, useEffect } from "react";
import CategoriaService from "../../services/CategoriaService";
import Categoria from "../../types/ICategoria"
import "./App.scss";

const categoriaService: CategoriaService = new CategoriaService();

const App = () => {
  const [categorias, setCategorias] = useState<Categoria[]>([]);

  useEffect(() => {
    categoriaService
      .buscaTodasCategorias()
      .then((res) => setCategorias(categorias.concat(res)));
  }, []);

  
  return (
    <ul>
      {categorias && categorias.map(function (d, idx) {
        return (
          <li key={idx}>
            {d.id} - {d.nome} - {d.descricao} - {d.urlImagem}
            <ul>
              {d.materias.map(function (m) {
                return <li key={m}>{m}</li>;
              })}
            </ul>
          </li>
        );
      })}
    </ul>
  );
};

export default App;
