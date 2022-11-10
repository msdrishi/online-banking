import "./App.css";
import  Login  from "./components/loginpage";
import React from "react";
import Register from "./components/Register";
import Welcome from "./components/Welcome";
import Forgotpassword from "./components/forgotPassword";

import { BrowserRouter as Router,Routes, Route } from "react-router-dom";
import Checkbalance from "./components/Pages/checkbalance";
import NewFD from "./components/Pages/newFD";
import Fundtransfer from "./components/Pages/fundtransfer";
import Events from "./components/Pages/events";
import Home from "./components/Home";
import ChangeAtmpin from "./components/Pages/changeAtmpin";


function App() {


  return (

  

    <>
    <Router>

      <Routes>
        <Route exact path="/" element={<Home />}></Route>
        <Route path="/welcome" element={<Welcome />}></Route>
        <Route path="/login" element={<Login />}></Route>
        <Route path="/register" element={<Register />}></Route>
        <Route path="/forgot" element={<Forgotpassword />}></Route>
        <Route path="/checkbalance" element={<Checkbalance />}></Route>
        <Route path="/fundtransfer" element={<Fundtransfer />}></Route>
        <Route path="/changeATMpin" element={<ChangeAtmpin />}></Route> 
        <Route path="/events" element={<Events />}></Route>
        <Route path="/newFD" element={<NewFD />}></Route>
        <Route path="/home" element={<Home/>}></Route>
      </Routes>
    </Router>
  </>
 
  );
}

export default App;
