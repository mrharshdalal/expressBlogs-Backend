package com.codewithme.expressblogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithme.expressblogs.exception.BlogPostNotFoundException;
import com.codewithme.expressblogs.model.BlogPost;
import com.codewithme.expressblogs.repository.BlogPostRepository;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;
    
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost getBlogPostById(Long postid) {
        return blogPostRepository.getBlogPostById(postid)
        .orElseThrow(() -> new BlogPostNotFoundException("BlogPost with post id" + postid + " was not found."));
        // return blogPostRepository.getBlogPostById(postid);
    }

    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public BlogPost updateBlogPost(Long postid, BlogPost blogPost) {
        BlogPost existingBlogPost = blogPostRepository.getBlogPostById(postid).orElse(null);
        if(existingBlogPost != null){
            existingBlogPost.setTitle(blogPost.getTitle());
            existingBlogPost.setContent(blogPost.getContent());
            // more update part here

            return blogPostRepository.save(existingBlogPost);

        }
        return null;
    }

    public boolean deleteBlogPost(Long postid) {
        if(blogPostRepository.existsById(postid)){
            blogPostRepository.deleteById(postid);
            return true;
        }
        return false;
    }

}
