package com.vieira.publication.service;

import com.vieira.publication.client.CommentCient;
import com.vieira.publication.domain.Comment;
import com.vieira.publication.exceptions.FallbackException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class CommentService {

    @Autowired
    private CommentCient commentCient;

    @Autowired
    private RedisService redisService;

    @CircuitBreaker(name = "comments", fallbackMethod = "getCommentsFallback")
    public List<Comment> getComments(String id){
        var comments = commentCient.getComments(id);
        redisService.save(id, comments);
        return comments;
    }

    private List<Comment> getCommentsFallback(String id, Throwable cause){
        log.warn("[WARN] fallback with id {}", id);
        return redisService.findById(id);
    }
}
