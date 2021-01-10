package com.socialMedia.services;

import com.socialMedia.model.Like;
import com.socialMedia.repository.PostLikesRepository;

import java.util.Arrays;
import java.util.List;

public class PostLikesService {
    public static void AddNewComment(String postId, Like like){
        List<Like> likes = PostLikesRepository.likesMap.get(postId);
        if(likes!= null){
            likes.add(like);
            PostLikesRepository.likesMap.replace(postId,likes);
        }
        else{
            PostLikesRepository.likesMap.put(postId, Arrays.asList(like));
        }
    }
}