package com.example.very_good.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.very_good.R;
import com.example.very_good.base.BaseActivity;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.BrandBean;
import com.example.very_good.interfaces.home.IBrand;
import com.example.very_good.presenter.home.BrandP;
import com.example.very_good.ui.adpter.BrandAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrandActivity extends BaseActivity<IBrand.BeandPre> implements IBrand.BrandView {
    @BindView(R.id.ry_brand)
    RecyclerView ryBrand;
    private ArrayList<BrandBean.DataBeanX.DataBean> list;
    private BrandTextAdapter brandTextAdapter;

    @Override
    protected int getLayout() {
        return R.layout.brand_layout;
    }

    @Override
    protected IBrand.BeandPre createPrenter() {
        return new BrandP();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter.getbrandP();
    }

    @Override
    public void getBrandReturn(BrandBean brandBean) {
        if (brandBean != null) {
            InitBrand(brandBean.getData().getData());
        }
    }

    private void InitBrand(List<BrandBean.DataBeanX.DataBean> data) {
        ryBrand.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        brandTextAdapter = new BrandTextAdapter(this, list);
        list.addAll(data);
        ryBrand.setAdapter(brandTextAdapter);

        brandTextAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(BrandActivity.this, BrandItemActivity.class);
                int id = data.get(pos).getId();
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }

    @Override
    public void tips(String tip) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
