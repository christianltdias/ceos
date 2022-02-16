import IService from "./IService";
import Categoria from "../types/ICategoria";

export default class CategoriaService extends IService {
  constructor() {
    super();
  }

  buscaTodasCategorias(): Promise<Categoria[]> {
    return this.httpGet(`/categorias`)
      .then((response) => response.data)
      .catch((err) => {
        throw new Error("Erro ao buscar lista de categorias: " + err.message);
      });
  }
}
