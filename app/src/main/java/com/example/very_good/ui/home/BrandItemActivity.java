package com.example.very_good.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseActivity;
import com.example.very_good.bean.BrandItemBean;
import com.example.very_good.bean.BrandTopBean;
import com.example.very_good.interfaces.home.IBrandItem;
import com.example.very_good.presenter.home.BrandItemPre;
import com.example.very_good.ui.adpter.Brand_item_adapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrandItemActivity extends BaseActivity<IBrandItem.BrandItemPre> implements IBrandItem.BrandItemView {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.recylerview)
    RecyclerView recylerview;
    private int id;
    private Brand_item_adapter brand_item_adapter;
    private ArrayList<BrandItemBean.DataBeanX.DataBean> list;

    @Override
    protected int getLayout() {
        return R.layout.branditem_item;
    }

    @Override
    protected IBrandItem.BrandItemPre createPrenter() {
        return new BrandItemPre();
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
    }

    @Override
    protected void initData() {
        presenter.getTopP(id);
        presenter.getItemP(id, 1, 1000);
    }

    @Override
    public void getBrandTop(BrandTopBean brandItemTopBean) {
        if (brandItemTopBean != null) {
            InitTop(brandItemTopBean.getData().getBrand());
        }

    }

    private void InitTop(BrandTopBean.DataBean.BrandBean brand) {
        Glide.with(this).load(brand.getList_pic_url()).into(image);
        title.setText(brand.getName());
        message.setText(brand.getSimple_desc());
    }

    @Override
    public void getBrandItem(BrandItemBean brandItemBean) {
        List<BrandItemBean.DataBeanX.DataBean> data = brandItemBean.getData().getData();
        recylerview.setLayoutManager(new GridLayoutManager(this, 2));
        list = new ArrayList<>();
        brand_item_adapter = new Brand_item_adapter(this, list);
        recylerview.setAdapter(brand_item_adapter);
        list.addAll(data);
        brand_item_adapter.notifyDataSetChanged();
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
