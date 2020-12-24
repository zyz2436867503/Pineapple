package com.example.very_good;

import android.content.Intent;

import com.example.very_good.base.BaseActivity;
import com.example.very_good.interfaces.IBasePresenter;

public abstract class SplaceActivity extends BaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.shopping_fragment;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {
//        startActivity(new Intent(SplaceActivity.this,MainActivity.class));
    }

    @Override
    protected void initData() {

    }
}
