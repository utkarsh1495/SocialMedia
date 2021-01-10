package com.socialMedia.repository;

import com.socialMedia.model.Comment;

import java.util.HashMap;
import java.util.List;

public class PostCommentsRepository {
    public static int count = 0;
    public static HashMap<String, List<Comment>> commentsMap = new HashMap<>();
}
