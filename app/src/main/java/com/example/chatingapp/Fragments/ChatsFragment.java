package com.example.chatingapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chatingapp.Adapters.UsersAdapter;
import com.example.chatingapp.R;
import com.example.chatingapp.Users;
import com.example.chatingapp.databinding.FragmentChatsBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChatsFragment extends Fragment {



    public ChatsFragment() {


    }

FragmentChatsBinding binding;
    ArrayList<Users> list = new ArrayList<>();
    FirebaseDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding= FragmentChatsBinding. inflate(inflater, container, false);
database = FirebaseDatabase.getInstance();
         UsersAdapter adapter = new UsersAdapter(list,getContext());
         binding.chatsRecyclerView.setAdapter(adapter);
         LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
         binding.chatsRecyclerView.setLayoutManager(linearLayoutManager);

         database.getReference().child("Users").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot snapshot) {

                 list.clear();
                 for(DataSnapshot dataSnapshot : snapshot.getChildren())
                 {
                     Users users = dataSnapshot.getValue(Users.class);

                     users.setUserId(dataSnapshot.getKey());
                     list.add(users);
                 }
                 adapter.notifyDataSetChanged();
             }

             @Override
             public void onCancelled(DatabaseError error) {

             }
         });
   return  binding.getRoot();
    }
}