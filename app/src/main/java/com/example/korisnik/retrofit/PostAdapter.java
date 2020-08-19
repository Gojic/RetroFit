package com.example.korisnik.retrofit;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korisnik on 07-Aug-19.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
   private Context context;
    private List<Post> postList = new ArrayList<>();

    public PostAdapter(Context context, List<Post> postList) {
        this.postList = postList;
        this.context = context;
    }
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View postView = inflater.inflate(R.layout.post_item, parent, false);

        // Return a new holder instance
        return new PostViewHolder(postView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = postList.get(position);

        TextView textViewId = holder.idView;
        TextView textViewUserId = holder.userIdView;
        TextView textViewTitle = holder.titleView;
        TextView textViewDesc = holder.descView;

        textViewId.setText(Integer.toString(post.getId()));
        textViewUserId.setText(Integer.toString(post.getUserId()));
        textViewTitle.setText(post.getTitle());
        textViewDesc.setText(post.getDecs());

//        holder.idView.setText(postList.get(position).getId());
//        holder.userIdView.setText(postList.get(position).getUserId());
//        holder.titleView.setText(postList.get(position).getTitle());
//        holder.descView.setText(postList.get(position).getDecs());


    }
    public void setujPostove(List<Post> posts) {
        this.postList = posts;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return postList.size();
    }





    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView idView;
        TextView userIdView;
        TextView titleView;
        TextView descView;


        public PostViewHolder(View itemView) {
            super(itemView);
            idView = itemView.findViewById(R.id.id);
            userIdView = itemView.findViewById(R.id.user_id);
            titleView = itemView.findViewById(R.id.post_title);
            descView = itemView.findViewById(R.id.descrtption);
        }
    }
}
