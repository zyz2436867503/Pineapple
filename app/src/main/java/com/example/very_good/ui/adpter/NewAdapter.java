package com.example.very_good.ui.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.HomeBean;

import java.nio.file.Path;
import java.util.List;

public class NewAdapter extends BaseAdapter {
    public NewAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.home_new_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        HomeBean.DataBean.NewGoodsListBean newgoods = (HomeBean.DataBean.NewGoodsListBean) data;
        TextView title = (TextView) vh.getViewById(R.id.tv_new_home);
        TextView price = (TextView) vh.getViewById(R.id.tv_price_home);
        ImageView ivhome = (ImageView) vh.getViewById(R.id.iv_new_home);
        Glide.with(context).load(newgoods.getList_pic_url()).into(ivhome);
        title.setText(newgoods.getName());
        price.setText("￥"+newgoods.getRetail_price());
    }
}
