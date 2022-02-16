import Token from '../types/Token';

function saveToken (userToken: Token): void  {
  sessionStorage.setItem("token", JSON.stringify(userToken));
}

function getToken (): string | null {
  const tokenString: string | null = sessionStorage.getItem("token");
  if(tokenString != null){
    const userToken: Token = JSON.parse(tokenString ? tokenString : "");

    if (userToken?.token && userToken?.tipo)
      return userToken?.tipo.concat(" ", userToken.token);
  }
  
    return null;
}

function isAuthenticated(): boolean {
  return getToken() != null;
}

export {saveToken, getToken, isAuthenticated}