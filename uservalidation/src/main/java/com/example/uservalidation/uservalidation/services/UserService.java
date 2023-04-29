package com.example.uservalidation.uservalidation.services;

import com.example.uservalidation.uservalidation.model.User;
import com.example.uservalidation.uservalidation.repository.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserData user;

    public ArrayList<User> getalluser(){
        return user.getalluser();
    };

    public String adduser(User userdata) {
        boolean res=user.adduser(userdata);
        if(res)
            return "user added successfully";
        return "user not added";
    }

    public ArrayList<User> getbyid(int userid) {
       return user.getbyid(userid);
    }
    public String deletebyid(int userid){
        return user.deletebyid(userid);
    }

    public ArrayList<User> updatebyid(int userid,String name) {
        return user.updatebyid(userid,name);
    }
}
