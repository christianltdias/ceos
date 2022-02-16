import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./App.scss";
import CategoriasLista from "../../containers/CategoriasLista/CategoriasLista";
import Login from "../../pages/Login/Login";
import Header from "../../containers/Header/Header";
import ProtectedRoute from "../../components/Routes/PrivateRoute/PrivateRoute";
import { isAuthenticated } from "../../hooks/TokenUtils";
import Home from "../Home/Home";
import NotFound from "../NotFound/NotFound";

const App = () => {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<Home />}/>
          <Route
            path="/categorias"
            element={
              <ProtectedRoute
                authenticationPath="/login"
                isAuthenticated={isAuthenticated()}
                outlet={
                  <>
                    <Header />
                    <CategoriasLista />
                  </>
                }
              />
            }
          />

          <Route path="/login" element={<Login />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </Router>
    </>
  );
};

export default App;
