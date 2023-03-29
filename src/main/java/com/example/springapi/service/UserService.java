package com.example.springapi.service;

import com.example.springapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList;
    public UserService(){
        userList=new ArrayList<>();
        User user1 =new User(1, "Hello",20,"hello@gmail.com");
        User user2 =new User(2, "From",21,"From@gmail.com");
        User user3 =new User(3, "Dhanish",22,"Dhanish@gmail.com");
        User user4 =new User(4, "Kumar",23,"Kumar@gmail.com");
        User user5 =new User(5, "Dot",24,"Dot@gmail.com");

        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }
    public Optional<User> getUser(Integer id) {
        Optional optional=Optional.empty();
        for(User user: userList){
            if(id ==user.getId()){
                optional=optional.of(user);
                return optional;
            }
        }
        return optional;
    }

    public boolean deleteUser(Integer id) {
        for (User user : userList) {
            if (user.getId()==id) {
                userList.remove(user);
                return true;
            }
        }
        return false;
    }
    public boolean updateUser(User newUser) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getId() == newUser.getId()) {
                userList.set(i, newUser);
                return true;
            }
        }
        return false;
    }

}