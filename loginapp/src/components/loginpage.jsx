import React from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Loginpage()
{

    const [username,setUserName]=useState('');
    
    const [password,setPassword]=useState('');
   

    const navigate= useNavigate();
    

    const callRegister=(e)=>{



        navigate("/register",{replace:true});

    }

    const loginsuccess=(username)=>{
        navigate("/welcome",{state:{name:username}});
    }

    const handleClick=(e)=> {
        e.preventDefault()
        const user={username,password}
        console.log(user); 

        fetch("http://localhost:8080/user/signin",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(user) 
        }).then(res=>res.json()).then((result)=>{
            console.log(result);
            if(result===0)
            {
                alert("wrong username and password");
                navigate("/login",{replace:true});
            }
            else
            {
                localStorage.setItem("authenticated", true);
                loginsuccess(user.email);
               
            }
        })
        


    }

    return(
        <>
        <div className='box'>

        
            <h1>Login</h1>
            <input type="text" placeholder="Email" value={username} onChange={ (e) =>setUserName(e.target.value)}></input><br></br>
            <input type="password" placeholder="Password"  value={password} onChange={ (e) =>setPassword(e.target.value)}></input><br></br>
            <input type="submit" onClick={handleClick} ></input>

            <p>Don't have an Account? </p><button onClick={callRegister}> Register</button>

         </div>
        </>
    );
}

export default Loginpage;