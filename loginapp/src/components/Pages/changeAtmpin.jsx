
import React from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function ChangeAtmpin(){

    const [oldpin,setOldpin]=useState('');
    const [newpin,setNewpin]=useState('');
    const [username,setUsername]=useState('');
    const [password,setPassword]=useState('');

   
    const navigate= useNavigate();

    const handleClick=(e)=>{



          const atmpin={username,password,oldpin,newpin};

         fetch("http://localhost:8080/user/changepin",{
             method:"POST",
             headers:{"Content-Type":"application/json"},
             body:JSON.stringify(atmpin) 
         }).then(res=>res.json()).then((result)=>{
            console.log(result);
            if(result===1)
            {
                alert("Updated");
                navigate("/",{replace:true});
            }
            else
            {
                
                alert("Wrong Details");
                
                navigate("/login",{replace:true});
               
            }
           
         })
         

    }
    return (
    
        <>
        
        <div className="page">


        <h3>Change Atmpin</h3>
        <div>
            <form>
                <p>Username:</p> <input type="text"  value={username} onChange={ (e) =>setUsername(e.target.value)}></input><br></br>
                <p>Password :</p><input type="text" value={password} onChange={ (e) =>setPassword(e.target.value)}></input>
             
                <br></br>

                <p>Old Pin:</p> <input type="text" value={oldpin} onChange={ (e) =>setOldpin(e.target.value)} ></input><br></br>

                <p>New Pin:</p> <input type="text" value={newpin} onChange={ (e) =>setNewpin(e.target.value)}></input><br></br>

                <input type="submit" value="Submit" onClick={handleClick}></input>


                
            </form>
        </div>



        </div>

        </>
    
        )
}

export default ChangeAtmpin;