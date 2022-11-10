import React from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function NewFD() {
    const [amount, setAmount] = useState('');


   const navigate=useNavigate();

    const handleClick=(e)=>{

        var fromaccount=document.getElementById('myacct').value;
        
        const fdperiod=document.getElementById("period").value;
  
        const fdproduct=document.getElementById("product").value;
        e.preventDefault()

         const newfd={fromaccount,amount,fdperiod,fdproduct}
  console.log(newfd)
         fetch("http://localhost:8080/user/newfd",{
             method:"POST",
             headers:{"Content-Type":"application/json"},
             body:JSON.stringify(newfd) 
         }).then(res=>res.json()).then((result)=>{
            
            console.log(result)

            var bal= localStorage.getItem("balance");
            bal=bal-amount;
            console.log(bal);
            localStorage.setItem("balance",bal);
            alert("Transfer completed");
             navigate("/welcome",{replace:true});
           
         })
         

    }


    return (
        <>
            <div className='box'>


                <h1>Fixed Deposit</h1>
                <label> Account id </label>
                <input type="text" placeholder="From Account" id="myacct" value={localStorage.getItem('userid')} ></input><br></br>
                <br />
                <label> FD Product </label>
                <select id='product'>
                    <option value="Regular"> Regular
                    </option>
                    <option value="Corporate"> Corporate
                    </option>
                    <option value="Cumulative"> Cumulative
                    </option>
                   
                </select> <br /><br />

                <label> FD Period </label>
                <select id='period'>
                    <option value="1 year"> 1 Years
                    </option>
                    <option value="2 years"> 2 Years
                    </option>
                    <option value="3 years"> 3 Years
                    </option>
                    <option value="4 years"> 4 Years
                    </option>
                </select> <br /> <br />
                <label> Amount </label>
                <input type="text" placeholder="Amount" value={amount} onChange={(e) => setAmount(e.target.value)}></input><br></br>


                <input type="submit" value="Transfer" onClick={handleClick}></input>

            </div>
        </>
    );
}

export default NewFD;