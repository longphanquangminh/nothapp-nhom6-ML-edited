package com.nothapp.appfuniture.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nothapp.appfuniture.R;
import com.nothapp.appfuniture.databinding.ActivityTiepTucMuaBinding;
import com.nothapp.appfuniture.Utils.Util;

public class TiepTucMuaActivity extends AppCompatActivity {
    private ActivityTiepTucMuaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tiep_tuc_mua);
        Intent intent = getIntent();
        int slMuaHang = intent.getIntExtra("soluong",0);
        binding.txtSoLuongDonHang.setText(String.valueOf(slMuaHang));
        binding.btnTiepTucMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.gioHangArrayList.clear();
                startActivity(new Intent(TiepTucMuaActivity.this,MainActivity.class));
            }
        });
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}