package com.example.chatingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.chatingapp.databinding.ActivitySignUpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("Loading...");


        binding.btnSignUp.setOnClickListener(v -> {
            progressDialog.show();


            mAuth.createUserWithEmailAndPassword(binding.edEmail.getText().toString(), binding.edPassword.getText().toString()).addOnCompleteListener(task -> {

                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    Users users = new Users(binding.eduserName.getText().toString(), binding.edEmail.getText().toString(), binding.edPassword.getText().toString());
                    String id = task.getResult().getUser().getUid();
                    database.getReference().child("Users").child(id).setValue(users);


                    Toast.makeText(getApplicationContext(), "User Created Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }

            });

        });

        binding.tvClickSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });



    }
}