package com.example.chatingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatingapp.MessageModel;
import com.example.chatingapp.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter{

    ArrayList<MessageModel> messageModels;
    Context context;

    int SENDER_VIEW_TYPE = 1;
    int RECIVER_VIEW_TYPE = 2;

    public ChatAdapter(ArrayList<MessageModel> messageModels, Context context) {
        this.messageModels = messageModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == SENDER_VIEW_TYPE)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_sender,parent,false);

            return new senderViewHolder(view);
        }
       else {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_reciver,parent,false);

            return new reciverViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
       if(messageModels.get(position).getuId().equals(FirebaseAuth.getInstance().getUid())){
           return SENDER_VIEW_TYPE;
       }
       else
       {
           return RECIVER_VIEW_TYPE;
       }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MessageModel messageModel = messageModels.get(position);

        if (holder.getClass()==senderViewHolder.class){

            ((senderViewHolder)holder).senderMsg.setText(messageModel.getMessage());


        }
        else {
            ((reciverViewHolder)holder).reciverMsg.setText(messageModel.getMessage());

        }

    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }



    public class reciverViewHolder extends RecyclerView.ViewHolder {

        TextView reciverMsg,reciverTime;
        public reciverViewHolder(@NonNull View itemView) {
            super(itemView);
            reciverMsg = itemView.findViewById(R.id.receiverText);
            reciverTime = itemView.findViewById(R.id.receiverTime);

        }
    }

    public class senderViewHolder extends RecyclerView.ViewHolder {

        TextView senderMsg,senderTime;
        public senderViewHolder(@NonNull View itemView) {
            super(itemView);
            senderMsg = itemView.findViewById(R.id.senderText);
            senderTime = itemView.findViewById(R.id.senderTime);

        }
    }
}
