import React from "react";
import { useNavigate } from "react-router-dom";
import {useLocation} from 'react-router-dom';
import { useState, useEffect } from "react";
function Welcome()
{

    const navigate=useNavigate();
    const location = useLocation();

    
  const [authenticated, setauthenticated] = useState(null);

  useEffect(() => {
    console.log(localStorage.getItem("authenticated"));
    const loggedInUser = localStorage.getItem("authenticated");
    if (!localStorage.getItem("authenticated")) {
      console.log("not valid");
      setauthenticated(loggedInUser);
      navigate("/login");
    }
  }, []);


    const callLogin=(e)=>{
        

        localStorage.removeItem("authenticated");
        navigate("/login",{replace:true});

    }
    return(

        <>
        <div className="welcome_box">
            <h1>Welcome</h1>
            {/* <div>{location.state.name}</div><br></br> */}
            <button onClick={callLogin}> Logout</button>

        </div>

        
        </>


    )

}
export default Welcome;