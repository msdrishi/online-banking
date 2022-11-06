package com.springreact.reactspring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.springreact.reactspring.models.User;

@Service
public class UserServiceImpl implements Userservice{
    

    @Autowired
	JdbcTemplate jdbcTemplate;
    
    @Override
    public void saveUser(User user){

        System.out.println("saving user details");

        
        int inserted = jdbcTemplate.update("insert into user(email,empid,password,phone,username) values(?,?,?,?, ?)", user.getEmail(), user.getEmpid(), user.getPassword(),user.getPhone(),user.getUsername());
        System.out.println(inserted);

    }
   
    @Override
    public boolean isExist(String username, String empid) {
		int count = jdbcTemplate.queryForObject("select count(*) from user where email=? or empid=?",
				Integer.class, username, empid);
		return count >= 1;
	}


    @Override
    public int isValid(String email,String password)
    {
        System.out.println(email+" "+password);
        int count = jdbcTemplate.queryForObject("select count(*) from user where email=? and password=?",
				Integer.class, email, password);

        System.out.println(count +" valid");
		return count;
    }
    


}
