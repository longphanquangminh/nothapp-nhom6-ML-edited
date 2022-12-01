package com.nothapp.appfuniture.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nothapp.appfuniture.R;
import com.nothapp.appfuniture.databinding.ActivityConfirmSignupBinding;

public class ConfirmSignupActivity extends AppCompatActivity {
    private ActivityConfirmSignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_confirm_signup);
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //Quay lại màn hình cũ
            }
        });
        binding.btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfirmSignupActivity.this, com.nothapp.appfuniture.activity.SigninActivity.class)); //chuyển màn hình
            }
        });
    }
}