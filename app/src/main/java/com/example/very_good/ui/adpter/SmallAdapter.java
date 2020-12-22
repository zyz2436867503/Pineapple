package com.example.very_good.ui.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.ChannelTypeBean;

import java.util.List;

public class SmallAdapter extends BaseAdapter {


    public SmallAdapter(Context context, List data) {
        super(context, data);

    }

    @Override
    protected int getLayout(int type) {
        return R.layout.smallfragment_adapter;
    }

    @Override
    protected void bindData(Object data, VH vh) {

        ChannelTypeBean.DataBeanX.DataBean channle = (ChannelTypeBean.DataBeanX.DataBean) data;
        ImageView small = (ImageView) vh.getViewById(R.id.iv_small);
        TextView tvsmall = (TextView) vh.getViewById(R.id.tv_small);
        TextView price = (TextView) vh.getViewById(R.id.tv_small_price);



        Glide.with(context).load(channle.getList_pic_url()).into(small);
        tvsmall.setText(channle.getName());
      //  price.setText(channle.getRetail_price());


    }
}
