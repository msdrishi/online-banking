import React from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Register()
{

    const [yourName,setYourName]=useState('');
    const [midName,setMiddleName]=useState('');
    const [lastName,setLastName]=useState('');
    const [username,setUserName]=useState('');
    const [password,setPassword]=useState('');
    const [securityAnswers,setSecurityAnswer]=useState('');
    const [mobileNumber,setmobileNumber]=useState('');

    const navigate= useNavigate();

    const callLogin=(e)=>{



        navigate("/login",{replace:true});

    }
    const home=(e)=>{



        navigate("/",{replace:true});

    }

 
     
        
      
      

    const handleClick=(e)=> {

        const x=document.getElementById("acct").value;
  
        const y=document.getElementById("ques").value;

        console.log(x+" "+y);

        var securityQuestions=y;
        var accountTypeID=x;
        var balance=1000;


  
        e.preventDefault()
        const user={yourName,midName,lastName,username,password,securityAnswers,securityQuestions,accountTypeID,mobileNumber,balance}
        console.log(user); 

        fetch("http://localhost:8080/user/signup",{
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
           <div className='homebox'>
        <button onClick={home}> Home </button>
        </div>
        <div className='box'>

        
            <h1>Register</h1>
            <input type="text" placeholder="Your Name"  value={yourName} onChange={ (e) =>setYourName(e.target.value)}></input>
            <input type="text" placeholder="Middle Name"  value={midName} onChange={ (e) =>setMiddleName(e.target.value)}></input><br></br>
            <input type="text" placeholder="Last Name"  value={lastName} onChange={ (e) =>setLastName(e.target.value)}></input>
            <input type="text" placeholder="mobile"  value={mobileNumber} onChange={ (e) =>setmobileNumber(e.target.value)}></input><br></br>
           


            <input type="text" placeholder="Username"  value={username} onChange={ (e) =>setUserName(e.target.value)}></input>
            <input type="password" placeholder="Password"  value={password} onChange={ (e) =>setPassword(e.target.value)}></input><br></br>
           
            <p>Security Question</p>
            <select id="ques">
                    <option value="Your Age?">Your Age?</option>
                    <option value="Your favourite Color?">Your favourite Color?</option>
                    <option value="Your favourite Team?">Your favourite Team?</option>
                    <option value="Your favourite Hero?">Your favourite Hero?</option>
            </select>
            <p>Security Answer</p>

            <input type="text" placeholder="Answer"  value={securityAnswers} onChange={ (e) =>setSecurityAnswer(e.target.value)}></input><br></br>
            
            

            <p>Select Account Type</p>
            <select name="" id="acct">
                    <option value="Current Account">Current Account</option>
                    <option value="Saving Account">Saving Account</option>
                    <option value="Salary Account">Salary Account</option>
            </select>

           <br></br>

           <input type="submit" onClick={handleClick} ></input>

           <p>Already have an Account? </p><button  onClick={ callLogin} > Login</button>

        </div>
        </>
    );
}

export default Register;