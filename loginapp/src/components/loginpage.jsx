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
    const home=(e)=>{



        navigate("/",{replace:true});

    }
    const loginsuccess=(username)=>{
        navigate("/welcome",{state:{name:username}});
    }



    const forgotpassword=(e)=>{
        e.preventDefault()
        

        navigate("/Forgot",{replace:true});

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
            if(result.id==="")
            {
                alert("wrong username and password");
                navigate("/login",{replace:true});
            }
            else
            {
                localStorage.setItem("authenticated", true);
                localStorage.setItem("userid",result.id);
                localStorage.setItem("username",result.name);
                localStorage.setItem("balance",result.balance);
                loginsuccess(user.email);
               
            }
        })
        


    }

    return(
        <>
        <div className='homebox'>
        <button onClick={home}> Home </button>
        </div>
        <div className='box'>

        
            <h1>Login</h1>
            <input type="text" placeholder="Email" value={username} onChange={ (e) =>setUserName(e.target.value)}></input><br></br>
            <input type="password" placeholder="Password"  value={password} onChange={ (e) =>setPassword(e.target.value)}></input><br></br>
            <input type="submit" onClick={handleClick} ></input>



            <p>Forgot Password </p><button onClick={forgotpassword}> Click Here</button>

            <p>Don't have an Account? </p><button onClick={callRegister}> Register</button>

         </div>
        </>
    );
}

export default Loginpage;