package com.example.very_good.ui.adpter;

import android.content.Context;
import android.widget.TextView;


import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.CategoryBean;
import com.example.very_good.utils.TxtUtils;

import java.util.List;

public class CategoryParameterAdapter extends BaseAdapter {

    public CategoryParameterAdapter(Context context, List Data) {
        super(context, Data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_category_parameter_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        CategoryBean.DataBeanX.AttributeBean bean = (CategoryBean.DataBeanX.AttributeBean) data;
        TextView key= (TextView) vh.getViewById(R.id.tv_category_parameter_key);
        TextView value= (TextView) vh.getViewById(R.id.tv_category_parameter_value);

        TxtUtils.setTextView(key,bean.getName());
        TxtUtils.setTextView(value,bean.getValue());
    }
}
