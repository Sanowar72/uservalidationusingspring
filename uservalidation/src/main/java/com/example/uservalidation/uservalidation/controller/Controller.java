package com.example.uservalidation.uservalidation.controller;

import com.example.uservalidation.uservalidation.model.User;
import com.example.uservalidation.uservalidation.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class Controller {
    @Autowired
    UserService userService;
    @GetMapping(value = "/home")
    public String home(){
        return "this is home";
    }
    @GetMapping(value = "/getAllUser")
    public ArrayList<User> getalluser(){
        return userService.getalluser();

    }
    @PostMapping(value = "/addUser")
    public String adduser(@Valid @RequestBody User user){
//        System.out.println(user.getDate());
        return userService.adduser(user);
    }
    @GetMapping(value = "/getuser/{userid}")
    public ArrayList<User> getbyid(@PathVariable int userid){
        return userService.getbyid(userid);
    }
    @PutMapping(value = "/updatebyid/{userid}/name/{name}")
    public ArrayList<User> updatebyid(@PathVariable int userid,@PathVariable String name){
        return userService.updatebyid(userid,name);
    }
    @DeleteMapping(value = "/deleteuser/{userid}")
    public String deletebyid(@PathVariable int userid){
        return userService.deletebyid(userid);
    }
}
