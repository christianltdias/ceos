import IService from "./IService";
import {saveToken} from "../hooks/TokenUtils"

export default class AutenticacaoService extends IService {

  constructor() {
    super();
  }

  logar(data: { login: string; senha: string }): Promise<boolean> {
    return this.httpPostSemHeader(`/auth`, data)
      .then((response) => {
        saveToken(response.data);
        return true;
      })
      .catch((err) => {
        throw new Error("Erro ao realizar login: " + err.message);
      });
  }
}
