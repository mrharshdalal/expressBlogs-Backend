package com.codewithme.expressblogs.controller;

import org.springframework.web.bind.annotation.RestController;

import com.codewithme.expressblogs.model.BlogPost;
import com.codewithme.expressblogs.service.BlogPostService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("api/blog")
public class BlogPostController{

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/getAllBlogs")
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return new ResponseEntity<>(blogPosts, HttpStatus.OK);
    }

    @GetMapping("/getBlogPostById/{postid}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long postid){
        BlogPost blogPost = blogPostService.getBlogPostById(postid);
        if(blogPost != null)
            return new ResponseEntity<>(blogPost, HttpStatus.OK);
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createBlogPost")    
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost){
        BlogPost newBlogPost = blogPostService.createBlogPost(blogPost);
        return new ResponseEntity<>(newBlogPost, HttpStatus.CREATED);
    }

    @PutMapping("updateBlogPost/{postid}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long postid, @RequestBody BlogPost blogPost) {
        BlogPost newBlogPost = blogPostService.updateBlogPost(postid, blogPost);
        if(newBlogPost != null)
            return new ResponseEntity<>(newBlogPost, HttpStatus.OK);
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("deleteBlogPost/{postid}")
    public ResponseEntity<String> deleteBlogPost(@PathVariable Long postid) {
        boolean deleted = blogPostService.deleteBlogPost(postid);

        if(deleted)
            return new ResponseEntity<>("Successfully deleted", HttpStatus.NO_CONTENT);

        return new ResponseEntity<>("BlogPost with given id not found", HttpStatus.NOT_FOUND);
    }
    
}