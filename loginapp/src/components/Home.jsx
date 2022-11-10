import React, { Component } from 'react'
import './Home.css';

import { useNavigate } from 'react-router-dom';

function Home() {

    const navigate= useNavigate();
    const callLogin=(e)=>{



        navigate("/login",{replace:true});

    }

       

    const callRegister=(e)=>{



        navigate("/register",{replace:true});

    }

        return (
            <div>


             <div className="navbar">
             <h1 id="title" className=" text-6xl text-orange-600 font-bold">Welcome to Mallya Bank</h1>
                    <button class="button" onClick={callLogin}> Login</button>
                    <button class="button" onClick={callRegister}> Register</button>
            </div>   
            <div className="banner-container">
                <div className="welcomepage">
                    <div className="content">
                    <h2 className="text-4xl mt-8 text-white">Personal Banking Services
                    What Are You Looking For?</h2>
                    <p>Our Banking is an industry that handles cash, credit, and other financial transactions. Banks provide a Safe place to Store extra cash and credit. They offer savings accounts, Certificates of Deposit, and checking accounts. Banks use these deposits to make loans.

                    </p>
                    </div>
                    
                   

                   <div className="cards">
                    <div className="card1">
                        <h3> Savings Accounts</h3>

                            <p>
                                Savings accounts pay interest to the depositor.
                            Depending on how long account holders hope to keep their money in the bank, 
                            they can open a regular savings account that pays a little interest or a certificate of deposit
                            (CD) that pays a little more interest. 
                            The CDs can earn interest for as little as a few months or as long as five years or more.
                            
                            </p>
                        </div>

                        <div className="card1">
                        <h3> Deposit</h3>

                            <p>
                            A bank deposit is the money someone places into a bank account.
                             The depositor lets the bank safe keep their money for some time,
                              in return for which the bank pays the depositor interest payments.
                               The bank uses this money to invest or provide loans to its borrowers and, 
                               in return, receive interests payments from them.

                            </p>
                        </div>
                        <div className="card1">
                        <h3> Fund transfer</h3>

                            <p>
                                A Funds Transfer is a sequence of events that results
                                in the movement of funds from the remitter to the beneficiary.
                                It is also defined as the remittance of funds from one party to 
                                itself or to another party through the banking system.

                            </p>
                        </div>
                   </div>
                </div>
            </div>

           
        </div>
        )
    

    

    }

    export default Home;