package com.socialMedia.services;

import com.socialMedia.exception.InvalidInputException;
import com.socialMedia.model.User;
import com.socialMedia.repository.UserRepository;

import java.net.SocketOption;

public class UserService {
    public static void AddUser(String name){
        User newUser = new User(name);
        newUser.setUserId(UserRepository.count++);
        if(UserRepository.userMap.containsKey(name)){
            throw new InvalidInputException("User is already registered!");
        }
        UserRepository.userMap.putIfAbsent(newUser.getName(), newUser);
        System.out.println("User Successfully Added");
    }
    public void RemoveUser(String email){
        UserRepository.userMap.remove(email);
    }
    public void UpdateUserDetails(User user){
        UserRepository.userMap.remove(user.getEmail());
        UserRepository.userMap.put(user.getEmail(), user);
    }
}
