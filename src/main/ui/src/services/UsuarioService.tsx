import {httpPost} from "./Service"; 


const cadastrar = (data: { login: string; senha: string }): Promise<any> => {
  return httpPost(`/usuarios/cadastrar`, data)
    .then((response) => {
      return response.data;
    })
    .catch((err) => {
      throw new Error("Erro ao realizar login: " + err.message);
    });
}


export {
  cadastrar
}