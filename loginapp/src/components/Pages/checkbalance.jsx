import { useEffect ,useState} from "react";
import { useNavigate } from 'react-router-dom';

function Checkbalance(){
 
    let initState;

    var num=0;
     
    const [authenticated, setauthenticated] = useState(null);
    const navigate= useNavigate();
    useEffect(() => {
        console.log(localStorage.getItem("authenticated"));
        const loggedInUser = localStorage.getItem("authenticated");
        if (!localStorage.getItem("authenticated")) {
          console.log("not valid");
          setauthenticated(loggedInUser);
          navigate("/login");
        }
      }, []);

    function trans(){
        
            var transactionId=localStorage.getItem('userid');
        

            console.log(transactionId);
            fetch("http://localhost:8080/user/GetTrans",{
                method:"POST",
                headers:{"Content-Type":"application/json"},
                body:JSON.stringify(transactionId) 
            }).then(res=>res.json()).then((result)=>{
            // console.log(result);
                initState=result;
                console.log(initState);
              //  document.getElementById("p").innerHTML=JSON.stringify(initState[0]);

              var tablearea = document.getElementById('table');
              var table = document.createElement('table');
              var tr = document.createElement('tr');   
              var td1 = document.createElement('th');
              var td2 = document.createElement('th');

              var td3 = document.createElement('th');
              var td4 = document.createElement('th');
              var text1 = document.createTextNode('TransactionId');
              

              var text2 = document.createTextNode('TransactionDate');
              var text3 = document.createTextNode('AccountType');
              var text4 = document.createTextNode('Amount');

              td1.appendChild(text1);
              td2.appendChild(text2);
              
              td3.appendChild(text3);
              td4.appendChild(text4);
              tr.appendChild(td1);
            tr.appendChild(td2);
            
            tr.appendChild(td3);
            tr.appendChild(td4);
              
              table.appendChild(tr);

                    for (var i = num; i < num+5; i++){
                        var tr = document.createElement('tr');   

                       

                        var td1 = document.createElement('td');
                        var td2 = document.createElement('td');

                        var td3 = document.createElement('td');
                        var td4 = document.createElement('td');
                        var text1 = document.createTextNode(initState[i].transactionId);
                        

                        var text2 = document.createTextNode(initState[i].transactionDate);
                        var text3 = document.createTextNode(initState[i].accountType);
                        var text4 = document.createTextNode(initState[i].amount);

                        td1.appendChild(text1);
                        td2.appendChild(text2);
                        
                        td3.appendChild(text3);
                        td4.appendChild(text4);

                        tr.appendChild(td1);
                        tr.appendChild(td2);
                        
                        tr.appendChild(td3);
                        tr.appendChild(td4);

                        table.appendChild(tr);
                    }
                    tablearea.appendChild(table);

                    num=num+5;
            
            })



            

    }


    return(


        <>

        <div className="page">
            
           <h1> Check Balance</h1>
           <div className="acctdls">
            <h3>Account Details</h3>
                <p>Name: {localStorage.getItem('username')}</p>
                <p>Current balance: {localStorage.getItem('balance')}</p>
           </div>

           <div className="trans">
           <h3>Transaction Details</h3>
               <button onClick={trans}>Click here</button>

               <table id="table">
                

               </table>
             
           </div>

           <div class="table">
                {/* <table>
                   <tr><th>TransactionId</th><th>TransDate</th><th>TransType</th><th>Amount</th></tr> 
               
                </table>

                          {initState} */}
                {/* <table>
                    <tr key={"header"}>
                        {Object.keys(state[0]).map((key) => (
                        <th>{key}</th>
                        ))}
                    </tr>
                    {state.map((item) => (
                        <tr key={item.id}>
                        {Object.values(item).map((val) => (
                            <td>{val}</td>
                        ))}
                        </tr>
                    ))}
                </table>
      */}

           </div>

        </div>
        
        
        </>

    )
}

export default Checkbalance;