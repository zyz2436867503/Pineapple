package com.example.very_good.ui.adpter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.HomeBean;
import com.example.very_good.ui.home.LiveItemActivity;

import java.util.List;

public class CateAdaper extends BaseAdapter {

    private GoodAdapter goodAdapter;

    public CateAdaper(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.cate_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        HomeBean.DataBean.CategoryListBean cate = (HomeBean.DataBean.CategoryListBean) data;
        TextView name = (TextView) vh.getViewById(R.id.cate_name);
        RecyclerView ry = (RecyclerView) vh.getViewById(R.id.ry_cate_small);
        ry.setLayoutManager(new GridLayoutManager(context, 2));
        goodAdapter = new GoodAdapter(context, ((HomeBean.DataBean.CategoryListBean) data).getGoodsList());

        ry.setAdapter(goodAdapter);
        goodAdapter.notifyDataSetChanged();
        List<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsList = cate.getGoodsList();
        name.setText(cate.getName());


        goodAdapter.addListClick(new IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(context, LiveItemActivity.class);
                int id = goodsList.get(pos).getId();
                Log.i("TAG", "itemClick: "+id);
                intent.putExtra("id", goodsList.get(pos).getId());
                context.startActivity(intent);
            }
        });


    }
}
