import {httpPost, httpGet} from "./Service"; 
import Token from "../types/Token"
import Usuario from "../types/Usuario"


const logar = (data: { login: string; senha: string }): Promise<Token> => {
  return httpPost(`/auth`, data)
    .then((response) => {
      return response.data;
    })
    .catch((err) => {
      throw new Error("Erro ao realizar login: " + err.message);
    });
}

const minhasInfo = (): Promise<Usuario> => {
  return httpGet('/usuarios')
  .then(response => response.data)
  .catch(err => {throw new Error("Erro ao buscar info usuário logado: " + err.message)});
}

export {
  logar,
  minhasInfo
}