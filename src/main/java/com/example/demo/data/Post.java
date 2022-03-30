package com.example.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {

    @Id
    private String post_code;
    @Column
    private String member_code;
    private String club_code;
    private String post_title;
    private String post_content;
    private String post_view;
    private String post_like;
    private String post_unlike;
    private String post_update;


    public String getPost_code() {
        return post_code;
    }


    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }
}

