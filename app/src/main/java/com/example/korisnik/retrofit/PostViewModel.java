package com.example.korisnik.retrofit;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class PostViewModel extends AndroidViewModel {
        private MutableLiveData<List<Post>> postList;
        private PostRepository postRepository;

    public PostViewModel(@NonNull Application application) {
        super(application);
        postRepository = PostRepository.getInstance();
        postList = postRepository.getPosts("title");
    }

    public LiveData<List<Post>> getPostsViewModel(){
        return postList;
    }
    public void search(String str){
        postRepository.search(str);
    }
}
