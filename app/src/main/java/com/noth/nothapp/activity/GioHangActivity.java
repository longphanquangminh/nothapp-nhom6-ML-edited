package com.noth.nothapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.noth.nothapp.databinding.ActivityGioHangBinding;
import com.noth.nothapp.Adapter.GioHangAdapter;
import com.noth.nothapp.Model.GioHang;
import com.noth.nothapp.R;
import com.noth.nothapp.Utils.Util;

import java.text.NumberFormat;
import java.util.Locale;

public class GioHangActivity extends AppCompatActivity implements GioHangAdapter.IGioHang {
    private static ActivityGioHangBinding binding;
    GioHangAdapter adapter;
    int slMua = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        binding = ActivityGioHangBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new GioHangAdapter(this);
        initRecylerViewGioHang();
        onClickBack();
        EvenChangeUtil();
        onClickMuaHang();
    }

    private void onClickMuaHang() {
        binding.linearMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khi click mua hàng thì sẽ truyền số lượng sang màn hình thanh toán
                Intent intent = new Intent(GioHangActivity.this,ThanhToanActivity.class);
                int sl = Integer.parseInt(binding.txtSoLuongMuaHang.getText().toString().trim());
                intent.putExtra("soluong",sl);
                startActivity(intent);
            }
        });
    }

    public static void EvenChangeUtil() {
        //Hàm tính tổng tiền và số lượng mua hàng . Khi tăng giảm thì tiền và số lượng cũng thay đổi ngay sau đó
        int tongTien = 0;
        int sl = 0;
        for (int i = 0; i< Util.gioHangArrayList.size(); i++){
            tongTien+= Util.gioHangArrayList.get(i).getGiaSp();
            sl += Util.gioHangArrayList.get(i).getSoLuongSP();
        }
        binding.txtSoLuongSP.setText("("+sl+")");
        binding.txtSoLuongMuaHang.setText(sl+"");
        binding.txtTongTienThanhToan.setText("vnd "+NumberFormat.getNumberInstance(Locale.getDefault()).format(tongTien));
    }

    private void initRecylerViewGioHang() {
        //khởi tạo adapter và hiển thị dữ liệu lên recyclerView
        adapter = new GioHangAdapter(this);
        binding.recylerGioHang.setLayoutManager(new LinearLayoutManager(this));
        binding.recylerGioHang.setAdapter(adapter);
    }

    private void onClickBack() {
        //Nút back quay lại màn hình cũ
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }

    @Override
    public int getCount() {
        //hàm trả về số lượng của list giỏ hàng
        if (Util.gioHangArrayList==null){
            return 0;
        }
        return Util.gioHangArrayList.size();
    }

    @Override
    public GioHang getListGioHang(int position) {
        return Util.gioHangArrayList.get(position);
    }
}