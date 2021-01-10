package com.socialMedia.repository;

import com.socialMedia.model.Like;

import java.util.HashMap;
import java.util.List;

public class PostLikesRepository {
    public static int count = 0;
    public static HashMap<String, List<Like>> likesMap = new HashMap<>();
}
