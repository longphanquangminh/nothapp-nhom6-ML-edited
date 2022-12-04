package com.noth.nothapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.noth.nothapp.R;
import com.noth.nothapp.databinding.ActivitySignupBinding;
import com.noth.nothapp.SQLite.SQLiteHelper;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;
    SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_signup);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sqLiteHelper = new SQLiteHelper(SignupActivity.this,"Database.sqlite",null,1);
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        customBtnSendOTP();
    }

    private void customBtnSendOTP() {
        binding.btnGuiOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.edtPhone.getText().toString();
                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(SignupActivity.this,"Dữ liệu không được để trống !!!",Toast.LENGTH_SHORT).show();
                }else {
                    //Thêm dữ liệu số điện thoại vào trong bảng database User
                    sqLiteHelper.QueryData("INSERT INTO User VALUES(null,'" + phone + "')");
                    startActivity(new Intent(SignupActivity.this,ConfirmSignupActivity.class));
                }
            }
        });
    }
}