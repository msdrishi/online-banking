package com.springreact.reactspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.reactspring.Service.Userservice;
import com.springreact.reactspring.models.User;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    
    @Autowired
    private Userservice userservice;

    
	

    @PostMapping(value="/add")
    public int postRegister(@RequestBody User user) {
     
        int result=0;

        boolean b=userservice.isExist(user.getEmail(), user.getEmpid());
        if(b==true)
        {
            System.out.println("Already user exist");
            return result;
        }
        else
        {
            userservice.saveUser(user);
            System.out.println("User Added");
            result=1;
        }

       

        return result;
    }
    

    @PostMapping(value="/login")
    public int postLogin(@RequestBody User user) {
      
        
        System.out.println("email:"+user.getEmail()+" pass:"+user.getPassword());

        int result=userservice.isValid(user.getEmail(), user.getPassword());

        System.out.println(result);
        return result;

    }


    
	
	
}
