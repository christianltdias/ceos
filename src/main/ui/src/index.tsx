import React from "react";
import ReactDOM from "react-dom";
import "./index.scss";
import App from "./pages/App/App";
import Header from "./containers/Header/Header";

ReactDOM.render(
  <React.StrictMode>
    <Header />
    <div className="container-fluid">
      <App />
    </div>
  </React.StrictMode>,
  document.getElementById("root")
);
