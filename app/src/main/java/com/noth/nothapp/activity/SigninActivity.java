package com.noth.nothapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.noth.nothapp.databinding.ActivitySigninBinding;
import com.noth.nothapp.Model.User;
import com.noth.nothapp.R;
import com.noth.nothapp.SQLite.SQLiteHelper;

import java.util.ArrayList;

public class SigninActivity extends AppCompatActivity {
    ActivitySigninBinding binding;
    SQLiteHelper sqLiteHelper;
    ArrayList<User> userArrayList;
    boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_signin);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initSQLite();
        userArrayList = new ArrayList<>();
        //Lấy dữ liệu từ bảng User sau đó add vào list
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM User");
        while (cursor.moveToNext()) {
            String phoneNumber = cursor.getString(1);
            userArrayList.add(new User(phoneNumber));
        }
        customBtnDangKy();
        customBtnDangNhap();

    }



    private void customBtnDangKy() {
        binding.txtDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this,SignupActivity.class));
            }
        });
    }

    private void customBtnDangNhap() {
        binding.btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.edtPhone.getText().toString().trim();
                //Kiểm tra số điện thoại của người dùng nhập và số điện thoại đăng ký nếu giống nhau thì đăng nhập thành công
                for(int i=0;i<userArrayList.size();i++){
                    if (phone.equals(userArrayList.get(i).getPhone())){
                        check = true;
                    }else {
                        check = false;
                    }
                }
                if (check){
                    Toast.makeText(SigninActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SigninActivity.this, MainActivity.class));
                }
                else {
                    Toast.makeText(SigninActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void initSQLite() {
        //Tạo bảng
        sqLiteHelper = new SQLiteHelper(SigninActivity.this,"Database.sqlite",null,1);
        sqLiteHelper.QueryData("CREATE TABLE IF NOT EXISTS User(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Phone VARCHAR(100))");
    }
}