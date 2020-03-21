package com.demo.retrofitexample.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Post implements Serializable {

    private Integer id;

    private String title;
    @SerializedName("body")

    private String text;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Integer getUserId() {
        return userId;
    }
}
