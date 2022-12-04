package com.noth.nothapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.noth.nothapp.R;
import com.noth.nothapp.databinding.ActivityThanhToanBinding;

public class ThanhToanActivity extends AppCompatActivity {
    ActivityThanhToanBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_thanh_toan);
        binding = ActivityThanhToanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        int slMuaHang = intent.getIntExtra("soluong",0);
        binding.txtSoLuongDonHang.setText(String.valueOf(slMuaHang));
        binding.btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThanhToanActivity.this,TiepTucMuaActivity.class);
                intent.putExtra("soluong",slMuaHang);
                startActivity(intent);
            }
        });
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.radioDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radioMomo.setChecked(false);
            }
        });
        binding.radioMomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radioDiscount.setChecked(false);
            }
        });


    }
}