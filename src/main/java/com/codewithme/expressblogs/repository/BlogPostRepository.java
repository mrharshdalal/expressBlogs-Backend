package com.codewithme.expressblogs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithme.expressblogs.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    Optional<BlogPost> getBlogPostById(Long postid);

}
