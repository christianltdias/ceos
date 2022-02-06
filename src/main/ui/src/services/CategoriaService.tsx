import IService from "./IService";
import Categoria from "../types/ICategoria";

export default class CategoriaService extends IService {
  constructor() {
    super();
  }

  buscaTodasCategorias(): Promise<Categoria[]> {
    return this.httpGet(`/categorias/1`)
    .then(
      (response) => response.data
    )
    .catch(err=> console.log("Erro" + err.message));
  }
}
