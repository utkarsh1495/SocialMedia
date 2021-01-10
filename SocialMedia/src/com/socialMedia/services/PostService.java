package com.socialMedia.services;

import com.socialMedia.model.Post;
import com.socialMedia.repository.FriendRepository;
import com.socialMedia.repository.PostRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PostService {
    public static void AddNewPost(String content, String userId){
        Post post = new Post(content,userId);
        post.setPostId(PostRepository.count++);
        List<Post> posts = PostRepository.postsMap.get(userId);
        if(posts!= null){
            posts.add(post);
            PostRepository.postsMap.replace(userId, posts);
        }
        else{
            PostRepository.postsMap.put(userId, Arrays.asList(post));
        }
        PostRepository.feed.add(post);
    }

    public static void getNewsFeed(){
        List<Post> posts = PostRepository.feed;
        for(int i=0;i<posts.size();i++){
            System.out.println("PostId: "+posts.get(i).getPostId());
            System.out.println("Content: "+posts.get(i).getContent());
            System.out.println("Posted by: "+posts.get(i).getUserId());
            System.out.println("Likes: "+0);
            System.out.println("Comments: "+0);
        }
    }

//    public void RemovePost(String postId, String userId){
//        List<Post> posts = PostRepository.postsMap.get(userId);
//        if(posts!=null){
//            posts.remove(posts.stream().findFirst(postId));
//        }
//    }

}
