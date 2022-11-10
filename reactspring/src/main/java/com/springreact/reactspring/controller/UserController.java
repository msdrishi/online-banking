package com.springreact.reactspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.reactspring.Respository.UserRep;
import com.springreact.reactspring.Service.MetaService;
import com.springreact.reactspring.Service.UserServiceImpl;
import com.springreact.reactspring.Service.Userservice;
import com.springreact.reactspring.models.Atmpin;
import com.springreact.reactspring.models.Newfd;
import com.springreact.reactspring.models.User;
import com.springreact.reactspring.request.MetaRequest;
import com.springreact.reactspring.response.MetaResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    
    @Autowired
    private Userservice userservice;

    
    @Autowired
    UserRep userRepository;
    
    @Autowired
    UserServiceImpl     userServiceImpl;
	
    static String str1;
    @Autowired
    private MetaService metaservice;

    @PostMapping(value="/checkIdBalanceName")
    public MetaResponse checkBalance(@RequestBody String username) {
      
        String name = metaservice.getFullName(username);
        
        String id = metaservice.getUserId(username);
 
        String balance = metaservice.getBalance(username);
        
        return new MetaResponse(id, name, balance);
        
    }

    @PostMapping(value="/signup")
    public int postRegister(@RequestBody User user) {
     
        int result=0;

        boolean b=userservice.isExist(user.getUsername(), user.getMobileNumber());
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
    
    @PostMapping("/forgotpassword")
	public User  forgotPassword( @RequestBody String username) {
		str1=username;

        str1=str1.substring(1,str1.length()-1);

        System.out.println(str1);
		User user = userServiceImpl.getByUsername(str1);
		
        System.out.println(user.getSecurityQuestions());
        if(user.getSecurityQuestions()!=null)
        {
            return user;
        }
        else{
            return null;
        }

	}


    @PostMapping("/changepass")
	public int  changepass( @RequestBody User user) {
		
        System.out.println("name:"+user.getUsername());
		User userval = userServiceImpl.getAnswer(user.getUsername());
		
        System.out.println("actual ans:"+userval.getSecurityAnswers());
        System.out.println("current ans:"+user.getSecurityAnswers());
        System.out.println("new pass:"+user.getPassword());
       
       

        if((userval.getSecurityAnswers()).equals(user.getSecurityAnswers()))
        {
            userServiceImpl.updatePassword(user.getPassword(),user.getUsername());
		
            return 1;
        }
        else{
            return 0;
        }
	}

    @PostMapping("/newfd")
	public int createNewFD(@RequestBody Newfd newfd) {

        System.out.println(newfd.getAmount()+" "+newfd.getFdperiod()+" "+newfd.getFdproduct()+" "+newfd.getFromaccount());
		userServiceImpl.saveNewfd(newfd);
		return 1;
	}

    @PostMapping(value="/signin")
    public MetaResponse postLogin(@RequestBody User user) {
      
        
        System.out.println("email:"+user.getUsername()+" pass:"+user.getPassword());

        int result=userservice.isValid(user.getUsername(), user.getPassword());
        
        MetaResponse metaresponse;
        if(result==1)
        {
            metaresponse= checkBalance(user.getUsername());
        }
        else{
            
           metaresponse= new MetaResponse("", "", "");
           
        }

        return metaresponse;
        

    }

  

    @PostMapping("/changepin")
    public int  changeAtmPin( @RequestBody Atmpin atmpin) {
		int result=userservice.isValid(atmpin.getUsername(), atmpin.getPassword());
        if(result==0){
            return 0;
        }else{
            userServiceImpl.updatePin(atmpin.getNewpin(), atmpin.getUsername());
            return 1;
        }
	}






    
	
	
}
