package com.socialMedia.services;

import com.socialMedia.repository.FriendRepository;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class FriendService {
    public static void AddFriend(String userId, String friendId){
        List<String> friends =  FriendRepository.friendsMap.get(userId);
        if(friends!=null) {
            if(friends.contains(friendId)){
                System.out.println("They are already friends!");
                return;
            }
            friends.add(friendId);
//            FriendRepository.friendsMap.get(userId).add(friendId);
        }else{
            FriendRepository.friendsMap.put(userId, Arrays.asList(friendId));
        }


        friends = FriendRepository.friendsMap.get(friendId);
        if(friends!=null) {
            friends.add(userId);
            FriendRepository.friendsMap.replace(friendId,friends);
        }else{
            FriendRepository.friendsMap.put(friendId, Arrays.asList(userId));
        }

        System.out.println("They are Friends now!");
    }

    public static void getFriends(String name){
        List<String> friends = FriendRepository.friendsMap.get(name);
        for(String f:friends){
            System.out.println(f);
        }
    }

    public void RemoveFriend(String userId, String friendId){
        List<String> friends = FriendRepository.friendsMap.get(userId);
        friends.remove(friendId);
    }
}
