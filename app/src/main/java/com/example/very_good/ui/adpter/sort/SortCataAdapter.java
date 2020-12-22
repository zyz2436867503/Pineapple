package com.example.very_good.ui.adpter.sort;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.sort.CateRightBean;

import java.util.List;

public class SortCataAdapter extends BaseAdapter {
    public SortCataAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.sortcata_adapter;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        CateRightBean.DataBean.CurrentCategoryBean.SubCategoryListBean categoryBean = (CateRightBean.DataBean.CurrentCategoryBean.SubCategoryListBean) data;
        TextView catatext = (TextView) vh.getViewById(R.id.tv_small_cata);
        ImageView cateimg = (ImageView) vh.getViewById(R.id.iv_small_cata);

        catatext.setText(categoryBean.getName());
        Glide.with(context).load(categoryBean.getWap_banner_url()).into(cateimg);
    }
}
