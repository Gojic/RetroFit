package com.example.korisnik.retrofit;

import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.korisnik.retrofit.MainActivity.BASE_URL;

public class PostRepository {
    PostAPI postAPI;
    private static PostRepository instance;
    private MutableLiveData<List<Post>> listMutableLiveData;

    public static PostRepository getInstance() {
        if (instance == null) {

            instance = new PostRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Post>> getPosts(String str) {

        listMutableLiveData = new MutableLiveData<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostAPI postAPI = retrofit.create(PostAPI.class);
        Call<List<Post>> listCall = postAPI.getPost(str);
        listCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {

                    return;
                }
                listMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

        return listMutableLiveData;

    }

    public void search(String string){
        postAPI.getPost(string);
    }


}
