package com.demo.retrofitexample.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Comment implements Serializable {
    private Integer id;
    private Integer postId;
    private String name;
    private String email;
    @SerializedName("body")
    private String commentText;

    public Integer getId() {
        return id;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCommentText() {
        return commentText;
    }
}
