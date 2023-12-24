package com.codewithme.expressblogs.model;

import java.util.Date;

import jakarta.persistence.Column;
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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "gender")
    private String gender;

    @Column(name = "password")
    private String password;

    @Column(name = "logourl")
    private String logourl;

    @Column(name = "createdat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // Constructors, getters, setters, and toString method

    public User() {
    }

    public User(Long userId, String fullname, String email, String username, String gender, String password,
            String logoUrl, Date createdAt) {
        this.userid = userId;
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.gender = gender;
        this.password = password;
        this.logourl = logoUrl;
        this.createdAt = createdAt != null ? new Date(createdAt.getTime()) : new Date();

    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userid +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", logourl='" + logourl + '\'' +
                ", created_at=" + createdAt +
                '}';
    }

}
