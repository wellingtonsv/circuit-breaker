package com.vieira.publication.client;

import com.vieira.publication.domain.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CommentCient", url = "${client.comments.url}")
public interface CommentCient {

    @GetMapping("/comments/{publicationId}")
    List<Comment> getComments(@PathVariable("publicationId") String publicationId);
}
