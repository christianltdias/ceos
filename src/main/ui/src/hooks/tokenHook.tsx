import { useState } from "react";
import { getToken } from "../services/Service"
import Token from '../types/Token';

export default function useToken() {

  const saveToken = async (userToken: Token | null): Promise<void> => {
    if(userToken === null)
      return sessionStorage.removeItem("token");

    sessionStorage.setItem("token", JSON.stringify(userToken));
    setToken(getToken());
  };

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
