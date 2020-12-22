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

public class HotAdapter extends BaseAdapter {
    public HotAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.home_hot_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        HomeBean.DataBean.HotGoodsListBean hot= (HomeBean.DataBean.HotGoodsListBean) data;
        ImageView iv = (ImageView) vh.getViewById(R.id.iv_hot);
        TextView name = (TextView) vh.getViewById(R.id.tv_hot_name);
        TextView brief = (TextView) vh.getViewById(R.id.tv_brief);
        TextView price = (TextView) vh.getViewById(R.id.tv_hot_price);

        Glide.with(context).load(hot.getList_pic_url()).into(iv);
        name.setText(hot.getName());
        price.setText("￥"+hot.getRetail_price());
        brief.setText(hot.getGoods_brief());
    }
}
