import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./App.scss";
import CategoriasLista from "../../containers/CategoriasLista/CategoriasLista";
import Login from "../../pages/Login/Login";
import Header from "../../containers/Header/Header";
import Footer from "../../containers/Footer/Footer";
import ProtectedRoute from "../../components/Routes/PrivateRoute/PrivateRoute";
import useToken from "../../hooks/tokenHook";
import Home from "../Home/Home";
import Signup from "../Signup/Signup"
import NotFound from "../NotFound/NotFound";
import { useState, useEffect } from "react";
import Token from "../../types/Token";

const App = () => {
  const {setToken, isAuthenticated} = useToken();
  const [logado, setLogado] = useState(isAuthenticated());

  const setUsuario = async (token: Token | null) => {
      await setToken(token);
      setLogado(isAuthenticated());
  }

  useEffect(() => {
  }, [logado])

  return (
    <>
      <Router>
        <Header logado={logado} logout={setUsuario}/>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route
            path="/categorias"
            element={
              <ProtectedRoute
                authenticationPath="/login"
                isAuthenticated={isAuthenticated()}
                outlet={<CategoriasLista />}
              />
            }
          />
          <Route path="/login" element={<Login logado={logado} setUsuario={setUsuario} />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
        <Footer />
      </Router>
    </>
  );
};

export default App;
