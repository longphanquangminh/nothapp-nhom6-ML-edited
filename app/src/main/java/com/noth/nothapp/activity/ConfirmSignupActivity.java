package com.noth.nothapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.noth.nothapp.R;
import com.noth.nothapp.databinding.ActivityConfirmSignupBinding;

public class ConfirmSignupActivity extends AppCompatActivity {
    ActivityConfirmSignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_confirm_signup);
        binding = ActivityConfirmSignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //Quay lại màn hình cũ
            }
        });
        binding.btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfirmSignupActivity.this, com.noth.nothapp.activity.SigninActivity.class)); //chuyển màn hình
            }
        });
    }
}