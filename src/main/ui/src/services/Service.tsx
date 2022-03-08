import axios, { AxiosRequestConfig, AxiosResponse } from "axios";
import Token from "../types/Token";
import useToken from "../hooks/tokenHook";

const getToken = (): string | null => {
  const tokenString: string | null = sessionStorage.getItem("token");

  if (tokenString !== null && tokenString !== "") {
    const userToken: Token = JSON.parse(tokenString ? tokenString : "");

    if (userToken?.token && userToken?.tipo)
      return userToken?.tipo.concat(" ", userToken.token);
  }

  return null;
};

const getValidToken = (): string => {
  var token = getToken();

  if (token === null) return "";

  return token;
};

const instance = axios.create({
  baseURL: "http://localhost:8080/ceos/api/",
});

const httpGet = (url: string): Promise<AxiosResponse<any, any>> => {
  return instance.get(url, {
    headers: { 'Authorization': getValidToken() },
  });
};

const httpPost = (url: string, data: any): Promise<AxiosResponse<any, any>> => {
  return instance.post(url, data, {
    headers: { 'Authorization': getValidToken() },
  });
};

export { httpGet, httpPost, getToken };
