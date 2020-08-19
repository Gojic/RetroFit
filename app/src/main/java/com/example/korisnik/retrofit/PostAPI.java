package com.example.korisnik.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Korisnik on 07-Aug-19.
 */

public interface PostAPI {

    @GET("posts/{title}")
    Call<List<Post>> getPost(@Query("title") String title);

}
