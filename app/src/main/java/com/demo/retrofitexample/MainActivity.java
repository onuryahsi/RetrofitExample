package com.demo.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.retrofitexample.Model.Comment;
import com.demo.retrofitexample.Model.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private TextView textViewPosts;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPosts = findViewById(R.id.txtView1);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY); // this will show the BODY of the response show in log

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient) // for logging we added
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        // getPosts();

        getComments();

        // getCommentsByPostId(new Integer[]{1, 3, 5, 9});

    }

    private void getPosts() {
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts("FAKE_HEADER");

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewPosts.setText("Code : " + response.code());
                    return;
                }

                List<Post> posts = response.body();
                for (Post post : posts) {
                    String result = "";
                    result += "Id : " + post.getId() + "\n";
                    result += "Title : " + post.getTitle() + "\n";
                    result += "Body : " + post.getText() + "\n\n";
                    textViewPosts.append(result);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getComments() {
        Map<String, String> mHeaders = new HashMap<String, String>();
        mHeaders.put("FakeHeader1", "Header1");
        mHeaders.put("FakeHeader2", "Header2");

        Call<List<Comment>> call = jsonPlaceHolderApi.getComments(mHeaders, 5);


        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    textViewPosts.setText("Code : " + response.code());
                    return;
                }

                List<Comment> comments = response.body();
                for (Comment comment : comments) {
                    String result = "";
                    result += "Id : " + comment.getId() + "\n";
                    result += "Post Id : " + comment.getPostId() + "\n";
                    result += "Name : " + comment.getName() + "\n";
                    result += "Email : " + comment.getEmail() + "\n";
                    result += "Comment : " + comment.getCommentText() + "\n\n";
                    textViewPosts.append(result);
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getCommentsByPostId(Integer[] postIDs) {
        Call<List<Comment>> comments = jsonPlaceHolderApi.getCommentsByPostId(postIDs);
        comments.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    textViewPosts.setText("Code : " + response.code());
                    return;
                }

                List<Comment> comments = response.body();
                for (Comment comment : comments) {
                    String result = "";
                    result += "Id : " + comment.getId() + "\n";
                    result += "Post Id : " + comment.getPostId() + "\n";
                    result += "Name : " + comment.getName() + "\n";
                    result += "Email : " + comment.getEmail() + "\n";
                    result += "Comment : " + comment.getCommentText() + "\n\n";
                    textViewPosts.append(result);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}