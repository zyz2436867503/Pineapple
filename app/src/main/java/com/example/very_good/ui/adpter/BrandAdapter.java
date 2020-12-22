package com.example.very_good.ui.adpter;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.HomeBean;

import java.nio.file.Path;
import java.util.List;

public class BrandAdapter extends BaseAdapter {

    public BrandAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.home_brand_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        HomeBean.DataBean.BrandListBean brand = (HomeBean.DataBean.BrandListBean) data;
        TextView ck = (TextView) vh.getViewById(R.id.tv_ck);
        TextView price = (TextView) vh.getViewById(R.id.tv_price);
        ImageView sock = (ImageView) vh.getViewById(R.id.iv_sock);

        ck.setText(brand.getName());
        price.setText(brand.getFloor_price());
        Glide.with(context).load(brand.getNew_pic_url()).into(sock);
    }
}
