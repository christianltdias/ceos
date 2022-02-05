import React, { useState, useEffect } from "react";
import axios from "axios";
// import logo from './logo.svg';
import "./App.css";

interface Categoria {
  id: number;
  nome: string;
  descricao: string;
  urlImagem: string;
  materias: string[];
}

const App = () => {
  const [categorias, setCategorias] = useState<Categoria[]>([]);

  useEffect(() => {
    axios.get(`http://localhost:8080/api/categorias`).then((res) => {
      console.log(res.data);
      const cat: Categoria[] = res.data;
      setCategorias(cat);
    });
  }, []);
  return (
    <ul>
      {categorias.map(function (d, idx) {
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
