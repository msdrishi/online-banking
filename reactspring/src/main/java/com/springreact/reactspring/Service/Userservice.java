package com.springreact.reactspring.Service;
import com.springreact.reactspring.models.User;


public interface Userservice
{
    User getByUsername(String name);
    void saveUser(User user);
    boolean isExist(String username, String empid);
    int isValid(String email,String empid);
    User getUserid(String username);
}
