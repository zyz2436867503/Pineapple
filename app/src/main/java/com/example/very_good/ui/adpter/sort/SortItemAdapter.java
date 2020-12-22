package com.example.very_good.ui.adpter.sort;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.sort.Sort_Data_InfoBean;

import java.util.List;

public class SortItemAdapter extends BaseAdapter {
    public SortItemAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.smallfragment_adapter;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        Sort_Data_InfoBean.DataBean.BrotherCategoryBean s= (Sort_Data_InfoBean.DataBean.BrotherCategoryBean) data;

        ImageView small = (ImageView) vh.getViewById(R.id.iv_small);
        TextView tvsmall = (TextView) vh.getViewById(R.id.tv_small);
        TextView price = (TextView) vh.getViewById(R.id.tv_small_price);



        Glide.with(context).load(s.getWap_banner_url()).into(small);
        tvsmall.setText(s.getName());
        //price.setText(s.getParent_id());
    }
}
