package com.example.very_good.ui.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.HomeBean;

import java.util.List;

public class GoodAdapter extends BaseAdapter {
    public GoodAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.good_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        HomeBean.DataBean.CategoryListBean.GoodsListBean goods= (HomeBean.DataBean.CategoryListBean.GoodsListBean) data;
        ImageView good = (ImageView) vh.getViewById(R.id.iv_good);
        TextView name = (TextView) vh.getViewById(R.id.tv_good_name);
        TextView price = (TextView) vh.getViewById(R.id.tv_good_price);

        Glide.with(context).load(goods.getList_pic_url()).into(good);
        name.setText(goods.getName());
        price.setText("￥"+goods.getRetail_price());
    }
}
