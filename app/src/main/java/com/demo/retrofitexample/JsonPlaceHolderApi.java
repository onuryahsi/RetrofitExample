package com.demo.retrofitexample;

import com.demo.retrofitexample.Model.Comment;
import com.demo.retrofitexample.Model.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonPlaceHolderApi {

    @Headers({"TestHeader: {testHeader}"})
    @GET("posts")
    Call<List<Post>> getPosts(@Header("testHeader") String header1);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@HeaderMap Map<String, String> header, @Path("id") Integer id);

    @GET("comments")
    Call<List<Comment>> getCommentsByPostId(@Query("postId") Integer[] postId);

    // @QueryMap
    // @FieldMap
    // @FormUrlEncoded
}
