import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
function Forgotpassword()
{

     const navigate=useNavigate();

    const [username,setUserName]=useState('');
    const [securityAnswers,setSecurityAnswer]=useState('');
    
    const [password,setPassword]=useState('');
    var ques;

//   useEffect(() => {
//     console.log(localStorage.getItem("authenticated"));
//     const loggedInUser = localStorage.getItem("authenticated");
//     if (!localStorage.getItem("authenticated")) {
//       console.log("not valid");
//       setauthenticated(loggedInUser);
//       navigate("/login");
//     }
//   }, []);


const checkAns=(e)=>{
    const user={username,securityAnswers,password}
    console.log(user);

    fetch("http://localhost:8080/user/changepass",{
     method:"POST",
     headers:{"Content-Type":"application/json"},
     body:JSON.stringify(user) 
 }).then(res=>res.json()).then((result)=>{
     console.log(result);
     if(result===1){
        alert("Password Changed successfully");
        navigate("/login",{replace:true});
     }
     else{
        alert("Wrong Answer");
        navigate("/login",{replace:true});
     }
    
 })

}
     
    const getUserDetails=(e)=>{
        
        const user={username}
       console.log(user);

       fetch("http://localhost:8080/user/forgotpassword",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(username) 
    }).then(res=>res.json()).then((result)=>{
        console.log(result);
        ques= result.securityQuestions;

       console.log(ques);
       document.getElementById('wbox').style.display="none";
       
       document.getElementById('qn').style.display="block";
       document.getElementById("question").innerHTML = ques;
    })

    }
    return(

        <>
        <div className="welcome_box" id="wbox" >
            <h1>Forgot Password</h1>
            {/* <div>{location.state.name}</div><br></br> */}

            <input type="text" placeholder="Email" value={username} onChange={ (e) =>setUserName(e.target.value)}></input><br></br>
            
            <button onClick={getUserDetails}> submit</button>

        </div>

        <div className="welcome_box" id="qn" >

            <h3 id="question">{ques}</h3>
            <input type="text" placeholder="Answer" value={securityAnswers} onChange={ (e) =>setSecurityAnswer(e.target.value)}></input><br></br>
            <input type="text" placeholder="New Password" value={password} onChange={ (e) =>setPassword(e.target.value)}></input><br></br>
            
            <button onClick={checkAns}> submit</button>
        </div>

        
        </>


    )

}
export default Forgotpassword;