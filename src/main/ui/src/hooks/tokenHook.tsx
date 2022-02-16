import { useState } from "react";
import Token from '../types/Token';

export default function useToken() {

  const saveToken = (userToken: Token): void => {
    sessionStorage.setItem("token", JSON.stringify(userToken));
    setToken(getToken());
  };

  function getToken(): string | null {
    const tokenString: string | null = sessionStorage.getItem("token");
    const userToken: Token = JSON.parse(tokenString ? tokenString : "");

    if (userToken?.token && userToken?.tipo)
      return userToken?.tipo.concat(" ", userToken.token);

    return null;
  }

  function isAuthenticated(): boolean {
    return getToken() != null;
  }

  const [token, setToken] = useState(getToken());

  return {
    setToken: saveToken,
    token,
    isAuthenticated
  }
}
