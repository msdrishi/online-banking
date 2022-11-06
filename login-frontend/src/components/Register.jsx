import React from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Register()
{

    const [email,setEmail]=useState('');
    const [password,setPassword]=useState('');
    const [empid,setEmpid]=useState('');
    const [username,setUserName]=useState('');
    const [phone,setPhone]=useState('');



    const navigate= useNavigate();

    const callLogin=(e)=>{



        navigate("/login",{replace:true});

    }

    const handleClick=(e)=> {
        e.preventDefault()
        const user={email,password,empid,username,phone}
        console.log(user); 

        fetch("http://localhost:8080/user/add",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(user) 
        }).then(res=>res.json()).then((result)=>{
            console.log(result);
            if(result===0)
            {
                alert("User Already Registered");
                navigate("/login",{replace:true});
            }
            else
            {
                
                alert("Registration Successfully");
                navigate("/login",{replace:true});
               
            }
        })
        
    }

    return(
        <>
        <div className='box'>

        
            <h1>Register</h1>
            <input type="text" placeholder="Name"  value={username} onChange={ (e) =>setUserName(e.target.value)}></input><br></br>
            <input type="text" placeholder="Empid"  value={empid} onChange={ (e) =>setEmpid(e.target.value)}></input><br></br>
            <input type="text" placeholder="Phone"  value={phone} onChange={ (e) =>setPhone(e.target.value)}></input><br></br>
            
            <input type="text" placeholder="Email" value={email} onChange={ (e) =>setEmail(e.target.value)}></input><br></br>
            <input type="password" placeholder="Password"  value={password} onChange={ (e) =>setPassword(e.target.value)}></input><br></br>
            <input type="submit" onClick={handleClick} ></input>

           <p>Already have an Account? </p><button  onClick={ callLogin} > Login</button>

        </div>
        </>
    );
}

export default Register;