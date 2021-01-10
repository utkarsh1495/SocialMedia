package com.socialMedia;

import com.socialMedia.repository.UserRepository;
import com.socialMedia.services.FriendService;
import com.socialMedia.services.PostService;
import com.socialMedia.services.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            String command = sc.nextLine();

            String[] s = command.split(" ");
            switch (s[0]) {
                case "register": {
                    UserService.AddUser(s[1]);
                    break;
                }
                case "login": {
                    String user = s[1];
                    if(!UserRepository.userMap.containsKey(s[1])){
                        System.out.println("User is not registered.");
                    }
                    while(true){
                        command = sc.nextLine();
                        s = command.split(" ");
                        if(s[0] == "logout") break;
                        switch(s[0]){
                            case "makePost":{
                                PostService.AddNewPost(s[1], s[2]);
                                break;
                            }
                            case "addFriend":{
                                if(!UserRepository.userMap.containsKey(s[1])){
                                    System.out.println("User is not registered.");
                                }
                                FriendService.AddFriend(user,s[1]);
                                break;
                            }
                            case "getNewsFeed":{
                                break;
                            }
                            case "getFriends":{
                                FriendService.getFriends(user);
                                break;
                            }
                        }
                    }
                    break;
                }
                default:{
                    System.out.println("This feature is not available yet!");
                }
            }
        }
    }

}
