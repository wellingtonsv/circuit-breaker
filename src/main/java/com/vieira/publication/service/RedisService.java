package com.vieira.publication.service;

import com.vieira.publication.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {

    public static final String KEY = "Comment";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void save(String id, List<Comment> comments){
        redisTemplate.opsForHash().put(KEY, id, comments);
    }

    public List<Comment> findById(String id){
        return (List<Comment>) redisTemplate.opsForHash().get(KEY, id);
    }
}
