package com.springreact.reactspring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class User {
    
    @TableGenerator(name = "Address_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Addr_Gen", initialValue = 10000, allocationSize = 10000)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String yourName;
    private String midName;
    private String lastName;
    private String username;
    private String password;
    private String securityQuestions;
    private String securityAnswers;
    private String accountTypeID;
    private String mobileNumber;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getYourName() {
        return yourName;
    }
    public void setYourName(String yourName) {
        this.yourName = yourName;
    }
    public String getMidName() {
        return midName;
    }
    public void setMidName(String midName) {
        this.midName = midName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSecurityQuestions() {
        return securityQuestions;
    }
    public void setSecurityQuestions(String securityQuestions) {
        this.securityQuestions = securityQuestions;
    }
    public String getSecurityAnswers() {
        return securityAnswers;
    }
    public void setSecurityAnswers(String securityAnswers) {
        this.securityAnswers = securityAnswers;
    }
    public String getAccountTypeID() {
        return accountTypeID;
    }
    public void setAccountTypeID(String accountTypeID) {
        this.accountTypeID = accountTypeID;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }



    


}
