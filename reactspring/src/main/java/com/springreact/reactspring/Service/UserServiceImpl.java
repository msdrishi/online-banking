package com.springreact.reactspring.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.springreact.reactspring.Respository.NewFdRep;
import com.springreact.reactspring.Respository.UserRep;
import com.springreact.reactspring.models.Newfd;
import com.springreact.reactspring.models.User;

@Service
public class UserServiceImpl implements Userservice{
    

    @Autowired
	JdbcTemplate jdbcTemplate;

    @Autowired
    UserRep userRep;
        
    @Autowired
    NewFdRep newFdRep;

    @Override
    public void saveUser(User user){

        System.out.println("saving user details");


        userRep.save(user);
        
        //int inserted = jdbcTemplate.update("insert into user(email,empid,password,phone,username) values(?,?,?,?,?)", user.getEmail(), user.getEmpid(), user.getPassword(),user.getPhone(),user.getUsername());
        System.out.println("inserted");

    }
   
    @Override
    public boolean isExist(String username, String empid) {
		int count = jdbcTemplate.queryForObject("select count(*) from user where username=? or password=?",
				Integer.class, username, empid);
		return count >= 1;
	}


    @Override
    public int isValid(String email,String password)
    {
        System.out.println(email+" "+password);
        int count = jdbcTemplate.queryForObject("select count(*) from user where username=? and password=?",
				Integer.class, email, password);

        System.out.println(count +" valid");
		return count;
    }
    
    @Override
    public User getUserid(String username){

      String count = jdbcTemplate.queryForObject("select id from user where username=?;",
      String.class, username);

      User user=new User();
      user.setId(Integer.parseInt(count));

      return user;

    }



    public User getAnswer(String username) {
      System.out.println("searching");
    	String u = jdbcTemplate.queryForObject("select security_answers from user where username=?",
				String.class, username);
        System.out.println(u);
        User user=new User();
        user.setSecurityAnswers(u);
    	return user;
    }

    @Override
    public User getByUsername(String username) {
      System.out.println("searching");
    	String u = jdbcTemplate.queryForObject("select security_questions from user where username=?",
				String.class, username);
        System.out.println(u);
        User user=new User();
        user.setSecurityQuestions(u);
    	return user;
    }

    public void saveNewfd(Newfd newfd) {
    
    	newFdRep.save(newfd);
      System.out.println(newfd.getId());
      
      int result=jdbcTemplate.update("update user set balance=balance-? where id=?", newfd.getAmount(),1);

      System.out.println(result);
    }
    
    public void updatePassword(String pass,String username) {
    	jdbcTemplate.update("update user set password=? where username=?", pass,username);
    }

    public void updatePin(String pin,String username) {
      jdbcTemplate.update("update user set atmpin=? where username=?", Integer.parseInt(pin),username);
    }

}
 class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    User emp = new User();
    emp.setId(rs.getInt("id"));
    emp.setSecurityQuestions(rs.getString("security_questions"));
    emp.setSecurityAnswers(rs.getString("security_answers"));
    return emp;
  }

  
}
