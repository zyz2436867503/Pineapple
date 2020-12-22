package com.example.very_good.ui.adpter;


import android.content.Context;
import android.widget.TextView;

import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.CategoryBean;
import com.example.very_good.utils.TxtUtils;

import java.util.List;

public class CategoryIssueAdapter extends BaseAdapter {


    public CategoryIssueAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return  R.layout.layout_category_issue_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {

        CategoryBean.DataBeanX.IssueBean bean = (CategoryBean.DataBeanX.IssueBean) data;
        TextView key= (TextView) vh.getViewById(R.id.tv_category_issue_key);
        TextView value= (TextView) vh.getViewById(R.id.tv_category_issue_value);

        TxtUtils.setTextView(key,bean.getQuestion());
        TxtUtils.setTextView(value,bean.getAnswer());
    }
}
