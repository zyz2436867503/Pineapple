package com.example.very_good.ui.adpter.discuss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;

import java.util.List;

public class DiscussAdapter extends BaseAdapter {

    public DiscussAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.jia_adapter;
    }

    @Override
    protected void bindData(Object data, VH vh) {

        String jiaLay = (String) data;

        ImageView jia = (ImageView) vh.getViewById(R.id.iv_jia);
        ImageView delete = (ImageView) vh.getViewById(R.id.iv_delete);
        Glide.with(context).load(jiaLay).into(jia);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
