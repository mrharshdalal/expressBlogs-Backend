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
    private String logoUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public User(){}

    public User(Long userId, String username, String email, String password, String logoUrl, Date createdAt){
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.logoUrl = logoUrl;
        this.createdAt = createdAt != null ? new Date(createdAt.getTime()) : new Date();
        
    }
    @Override
    public String toString(){
        return "User{" + 
        "userid=" + userId +
        ", username='" + username +
        ", email= " + email +
        ", logoUrl= " + logoUrl +
        ", created_at= " + createdAt+
        '}';

    }
}
