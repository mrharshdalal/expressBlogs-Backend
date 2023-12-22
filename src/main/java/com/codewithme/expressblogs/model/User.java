package com.codewithme.expressblogs.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String email;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public User(){}

    public User(Long userId, String username, String email, String password, Date createdAt){
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt != null ? new Date(createdAt.getTime()) : new Date();
        
    }
    @Override
    public String toString(){
        return "User{" + 
        "userid=" + userId +
        ", username='" + username +
        ", email= " + email +
        ", created_at= " + createdAt+"}";
    }
}
