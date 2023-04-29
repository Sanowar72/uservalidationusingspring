package com.example.uservalidation.uservalidation.repository;

import com.example.uservalidation.uservalidation.model.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

@Repository
// @EntityScan
public class UserData {
    ArrayList<User> UserList = new ArrayList<>();

    // LocalDate date = LocalDate.of(2023, 4, 29);
    // LocalTime time = LocalTime.of(10, 30);
    // UserList.add(new User(1,"sanowar","10 march
    // 1998","sanowar@gmail.com","7903288853",date,time));
    public UserData() {
        // String dateString = "2022-05-01T10:30:00"; // Date and time in ISO-8601
        // format
        // DateTimeFormatter formatter =
        // DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        // LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        // UserList.add(new User(1,"sanowar","10 march
        // 1998","sanowar@gmail.com","7903288853",dateTime));
        LocalDate date = LocalDate.of(2023, 4, 29);
        LocalDate dob = LocalDate.of(1998, 3, 10);
        LocalTime time = LocalTime.of(10, 30);
        UserList.add(new User(0, "sanowar", dob, "sanowar@gmail.com", "7903288853", date, time));
    }

    public ArrayList<User> getalluser() {
        return UserList;
    }

    public boolean adduser(User userdata) {
        UserList.add(userdata);
        return true;
    }

    public ArrayList<User> getbyid(int userid) {
        ArrayList<User> userbyid = getalluser();
        ArrayList<User> tempuser = new ArrayList<>();
        for (User user : userbyid) {
            int temp = user.getId();
            if (temp == userid) {
                tempuser.add(user);
                break;
            }
        }
        return tempuser;
    }

    public User findbyid(int userid) {
        ArrayList<User> userbyid = getalluser();
        ArrayList<User> tempuser = new ArrayList<>();
        for (User user : userbyid) {
            int temp = user.getId();
            if (temp == userid) {
                return user;
                // break;
            }
        }
        return null;
    }

    public String deletebyid(int userid) {
        ArrayList<User> userbyid = getalluser();
        for (User user : userbyid) {
            int temp = user.getId();
            if (temp == userid) {
                userbyid.remove(user);
                break;
            }
        }
        return "user deleted...........!!!!!";
    }

    public ArrayList<User> updatebyid(int userid, String name) {
        User tempuser = findbyid(userid);
        ArrayList<User> updatedlist = new ArrayList<>();
        tempuser.setName(name);
        UserList.remove(tempuser);
        UserList.add(tempuser);
        updatedlist.add(tempuser);
        return updatedlist;
    }
}
