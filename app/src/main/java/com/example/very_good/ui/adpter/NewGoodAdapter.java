package com.example.very_good.ui.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.HomeBean;
import com.example.very_good.bean.NewListBean;

import java.util.List;

public class NewGoodAdapter extends BaseAdapter {
    public NewGoodAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.newall_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        NewListBean.DataBeanX.DataBean newitem = (NewListBean.DataBeanX.DataBean) data;
        ImageView iv = (ImageView) vh.getViewById(R.id.iv_newitem_home);
        TextView title = (TextView) vh.getViewById(R.id.tv_newitem_home);
        TextView price = (TextView) vh.getViewById(R.id.tv_newprice_home);

        Glide.with(context).load(newitem.getList_pic_url()).into(iv);
        title.setText(newitem.getName());
        price.setText("￥"+newitem.getRetail_price());
    }
}
