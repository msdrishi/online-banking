import React from "react";
import "./style.css"
import { useNavigate } from 'react-router-dom';

import { useEffect ,useState} from "react";
function Navbar()
{

    const navigate= useNavigate();


    
    const [authenticated, setauthenticated] = useState(null);

    function logout()
    {
        localStorage.removeItem('authenticated');
        localStorage.clear();
        navigate("/login",{replace:true});

    }

    
  useEffect(() => {
    console.log(localStorage.getItem("authenticated"));
    const loggedInUser = localStorage.getItem("authenticated");
    if (!localStorage.getItem("authenticated")) {
      console.log("not valid");
      setauthenticated(loggedInUser);
      navigate("/login");
    }
  }, []);

    if(localStorage.getItem('authenticated'))
    {
        navigate("/login")
    }
   
    
    
    return(

        <>
        <div className="welcomename">
        <h2>Welcome {localStorage.getItem('username')}</h2>
        
        </div>
    
        <nav className="nav">

            <ul>
                <li></li>
            </ul>

           
            <ul>
                <li>
                   
                <a href="/checkbalance">Check balance</a>
                </li>
                <li>
                    <a href="/fundtransfer">Fund Transfer</a>
                </li>
                <li>
                    <a href="/newfd">New FD</a>
                </li>
        
                <li>
                    <a href="/changeATMpin">Change ATM pin</a>
                </li>
                <li>
                    
                <a href="/login" onClick={logout}>Logout</a>
                </li>
            </ul>
        </nav>

        </>

    )

}
export default Navbar;