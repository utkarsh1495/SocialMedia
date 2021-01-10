package com.socialMedia.repository;

import com.socialMedia.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostRepository {
    public static int count = 0;
    public static List<Post> feed = new ArrayList<Post>();
    public static HashMap<String, List<Post>> postsMap = new HashMap<>();
}
