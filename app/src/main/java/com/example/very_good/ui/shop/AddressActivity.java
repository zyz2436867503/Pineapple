package com.example.very_good.ui.shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.very_good.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AddressActivity extends AppCompatActivity {
    @BindView(R.id.mRlv_Address)
    RecyclerView mRlvAddress;
    @BindView(R.id.btn_address_add)
    Button btn_Add;
    private Unbinder bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        bind = ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_address_add)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_address_add:
                Intent intent = new Intent(AddressActivity.this, Address_AddActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}