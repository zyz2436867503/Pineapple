package com.example.very_good.ui.adpter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.NewListBean;

import java.util.List;

public class SortAdapter extends BaseAdapter {
    public SortAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.sort_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        NewListBean.DataBeanX.FilterCategoryBean filterCategoryBean = (NewListBean.DataBeanX.FilterCategoryBean) data;
        TextView sort = (TextView) vh.getViewById(R.id.tv_sort);

        sort.setText(filterCategoryBean.getName());
    }
}
