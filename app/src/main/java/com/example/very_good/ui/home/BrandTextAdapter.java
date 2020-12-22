package com.example.very_good.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.BrandBean;

import java.util.List;

public class BrandTextAdapter extends BaseAdapter {
    public BrandTextAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.brand_text_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        BrandBean.DataBeanX.DataBean brand = (BrandBean.DataBeanX.DataBean) data;
        TextView text = (TextView) vh.getViewById(R.id.tv_brand_text);
        TextView price = (TextView) vh.getViewById(R.id.tv_brand_price);
        ImageView iv = (ImageView) vh.getViewById(R.id.iv_brand_text);

        price.setText(brand.getFloor_price()+""+"元起");
        text.setText(brand.getName());
        Glide.with(context).load(brand.getApp_list_pic_url()).into(iv);

    }
}
