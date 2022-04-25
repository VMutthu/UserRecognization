package com.example.userrecognization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainScreen extends AppCompatActivity {
    AppCompatButton adduser,validate_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        adduser=(AppCompatButton) findViewById(R.id.adduser);
        validate_user=(AppCompatButton) findViewById(R.id.validateuser);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(MainScreen.this,AddUser.class));
            }
        });
        validate_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(MainScreen.this,MainActivity.class));

            }
        });
    }
}