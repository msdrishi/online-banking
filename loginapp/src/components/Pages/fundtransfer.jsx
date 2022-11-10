
import React from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';


function Fundtransfer(){

    const [beneficiary,setBeneficiary]=useState('');
    const [beneficiary_ACCT,setBeneficiaryAcct]=useState('');
    const [beneficiary_IFSC,setBeneficiaryIFSC]=useState('');
    const [amount,setAmount]=useState('');
    const [remarks,setRemarks]=useState('');


   
    const navigate= useNavigate();

    const handleClick=(e)=>{

        
        e.preventDefault()


  
         const beneficiary_ACCT_TYPE=document.getElementById("accttype").value;


        var myacctid=localStorage.getItem('userid');

       console.log(myacctid);

         const transferrequest={myacctid,beneficiary,beneficiary_ACCT,beneficiary_ACCT_TYPE,beneficiary_IFSC,amount,remarks};
         console.log(transferrequest); 


         fetch("http://localhost:8080/user/fundTransfer",{
             method:"POST",
             headers:{"Content-Type":"application/json"},
             body:JSON.stringify(transferrequest) 
         }).then(res=>res.json()).then((result)=>{
            
            console.log(result)
            if(result===1)
            {
                alert("Low Balance");
                navigate("/login",{replace:true});
            }
            else if(result===2)
            {
                
                
               var bal= localStorage.getItem("balance");
               bal=bal-amount;
               console.log(bal);
               localStorage.setItem("balance",bal);
               alert("Transfer completed");
                navigate("/welcome",{replace:true});
               
            }
            else if(result===3)
            {
                alert("Account Number and Beneficiary details are invalid");
                
                navigate("/welcome",{replace:true});
            }
            else if(result==4)
            {
                alert("Invalid account number");
                
                navigate("/welcome",{replace:true});
            }
            else{
                alert("Invalid beneficiary details");
                
                navigate("/welcome",{replace:true});

            }
           
         })
         

    }

 
     
        
      
    return (
    
        <>
        
        <div className="page">


        <h3>Fund Transfer</h3>
        <div>
            <form>
                <p>From Account:</p> <input type="text"  value={localStorage.getItem('userid')} ></input><br></br>
                <p>Beneficiary :</p><input type="text" value={beneficiary} onChange={ (e) =>setBeneficiary(e.target.value)}></input>
             
                <br></br>

                <p>Beneficiary Account:</p> <input type="text" value={beneficiary_ACCT} onChange={ (e) =>setBeneficiaryAcct(e.target.value)} ></input><br></br>

                <p>Beneficiary IFSC Code:</p> <input type="text" value={beneficiary_IFSC} onChange={ (e) =>setBeneficiaryIFSC(e.target.value)}></input><br></br>

                
                <p>Beneficiary Account Type</p>
                <select id="accttype">
                    <option>Salary Account</option>
                    <option>Saving Account</option>
                    <option>deposit</option>
                </select>
                <br></br>

                <p>Amount:</p><input type="text" value={amount} onChange={ (e) =>setAmount(e.target.value)}></input><br></br>
                <p>Remarks:</p><input type="text" value={remarks} onChange={ (e) =>setRemarks(e.target.value)}></input><br></br>

                <input type="submit" value="Transfer" onClick={handleClick}></input>


                
            </form>
        </div>



        </div>

        </>
    
        )
}

export default Fundtransfer;