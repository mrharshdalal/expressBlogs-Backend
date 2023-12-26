package com.codewithme.expressblogs.exception;

public class BlogPostNotFoundException extends RuntimeException{
    public BlogPostNotFoundException(String message){
        super(message);
    }
}
