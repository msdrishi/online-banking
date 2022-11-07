import "./App.css";
import  Login  from "./components/loginpage";
import React from "react";
import Register from "./components/Register";
import Welcome from "./components/Welcome";

import { BrowserRouter as Router,Routes, Route } from "react-router-dom";


function App() {


  return (

  

    <>
    <Router>

      <Routes>
        <Route exact path="/" element={<Login />}></Route>
        <Route path="/welcome" element={<Welcome />}></Route>
        <Route path="/login" element={<Login />}></Route>
        <Route path="/register" element={<Register />}></Route>
      </Routes>
    </Router>
  </>
 
  );
}

export default App;
