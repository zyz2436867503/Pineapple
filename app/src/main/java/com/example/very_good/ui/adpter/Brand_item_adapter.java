package com.example.very_good.ui.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.BrandItemBean;

import java.util.List;

public class Brand_item_adapter extends BaseAdapter {
    public Brand_item_adapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.branditem_ada_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        BrandItemBean.DataBeanX.DataBean BrandItem = (BrandItemBean.DataBeanX.DataBean) data;
        ImageView iv = (ImageView) vh.getViewById(R.id.iv_branditem_home);
        TextView title = (TextView) vh.getViewById(R.id.tv_brandnew_home);
        TextView price = (TextView) vh.getViewById(R.id.tv_brandprice_home);
        Glide.with(context).load(BrandItem.getList_pic_url()).into(iv);
        title.setText(BrandItem.getName());
        price.setText(BrandItem.getRetail_price());

    }
}
