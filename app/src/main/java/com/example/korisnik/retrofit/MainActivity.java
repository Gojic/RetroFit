package com.example.korisnik.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Post> listaPostova = new ArrayList<>();
    private PostAdapter postAdapter;
    private PostViewModel postViewModel;
    public static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public EditText editText;
    public Button button;
    private String seachValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleview);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        editText = findViewById(R.id.pretraga_po_nazivu);
        button = findViewById(R.id.dugme_za_pretragu);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seachValue = editText.getText().toString().trim();
                postViewModel.search(seachValue);
            }
        });
        postViewModel.getPostsViewModel().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                postAdapter.setujPostove(posts);
            }

        });

        generateDataList(listaPostova);

    }


    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Post> postovi) {
        postAdapter = new PostAdapter(this, postovi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);
    }

}
