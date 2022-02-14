package com.example.chatingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatingapp.ChatDetailActivity;
import com.example.chatingapp.R;
import com.example.chatingapp.Users;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.viewHolder>{

    ArrayList<Users> list;
    Context context;

    public UsersAdapter(ArrayList<Users> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_showuser,parent,false);


        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder( UsersAdapter.viewHolder holder, int position) {
Users users = list.get(position);
        Picasso.get().load(users.getProfilepic()).placeholder(android.R.drawable.ic_menu_gallery).into(holder.imageView);
   holder.userName.setText(users.getUserName());
   holder.itemView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent = new Intent(context, ChatDetailActivity.class);

           intent.putExtra("userId",users.getUserId());
           intent.putExtra("profilePic",users.getProfilepic());
           intent.putExtra("userName",users.getUserName());
           context.startActivity(intent);
       }
   });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView userName,lastMessage;
        public viewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.profile_image);
            userName = itemView.findViewById(R.id.userNameList);
            lastMessage = itemView.findViewById(R.id.lastMessage);


        }
    }
}
