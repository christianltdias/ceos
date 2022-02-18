import { httpGet } from "./Service";
import Categoria from "../types/ICategoria";

const buscaTodasCategorias = (): Promise<Categoria[]> => {
  return httpGet(`/categorias`)
    .then((response) => response.data)
    .catch((err) => {
      throw new Error("Erro ao buscar lista de categorias: " + err.message);
    });
};

export {
  buscaTodasCategorias
}
