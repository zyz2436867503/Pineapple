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

public class TopAdapter extends BaseAdapter {
    public TopAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.home_top;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        HomeBean.DataBean.TopicListBean top= (HomeBean.DataBean.TopicListBean) data;
        ImageView ivtop = (ImageView) vh.getViewById(R.id.iv_top);
        TextView title = (TextView) vh.getViewById(R.id.tv_top_title);
        TextView subtitle = (TextView) vh.getViewById(R.id.tv_top_subtitile);
        TextView price = (TextView) vh.getViewById(R.id.tv_top_price);
        Glide.with(context).load(top.getItem_pic_url()).into(ivtop);
        title.setText(top.getTitle());
        subtitle.setText(top.getSubtitle());
        price.setText("￥"+top.getPrice_info()+"元起");
    }
}
