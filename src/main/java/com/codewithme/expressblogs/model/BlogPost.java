package com.codewithme.expressblogs.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.ToString;

@Entity
@Data
@Table(name = "blogposts")
// @NoArgsConstructor
// @AllArgsConstructor
// @ToString
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    private int likescount;

    @Column(nullable = false)
    private Timestamp createdat;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_url")
    private String imageUrl;

    public BlogPost(){}

    public BlogPost(String title, String content, User user, int likescount, Timestamp createdat, byte[] image, String imageUrl) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.likescount = likescount;
        this.createdat = createdat;
        this.image = image;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString(){
        return "BlogPost{" +
        "postid=" + postid +
        ", title='" + title + '\'' +
        ", content=REDACTED" +
        ", user=" + user.getUsername()+ 
        ", likescount=" + likescount +
        ", createdat=" + createdat +
        '}';
    }

}
