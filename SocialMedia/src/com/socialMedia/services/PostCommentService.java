package com.socialMedia.services;

import com.socialMedia.model.Comment;
import com.socialMedia.repository.PostCommentsRepository;

import java.util.Arrays;
import java.util.List;

public class PostCommentService {
    public static void AddNewComment(String postId, Comment comment){
        List<Comment> comments = PostCommentsRepository.commentsMap.get(postId);
        if(comments!= null){
            comments.add(comment);
            PostCommentsRepository.commentsMap.replace(postId,comments);
        }
        else{
            PostCommentsRepository.commentsMap.put(postId, Arrays.asList(comment));
        }
    }
}
