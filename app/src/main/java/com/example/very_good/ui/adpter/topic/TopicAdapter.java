package com.example.very_good.ui.adpter.topic;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.topic.TopicBean;
import com.example.very_good.utils.TxtUtils;

import java.util.List;

public class TopicAdapter extends BaseAdapter {
    public TopicAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.fragment_topic_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        TopicBean.DataBeanX.DataBean dataBean = (TopicBean.DataBeanX.DataBean) data;

        ImageView topic_rlv_item_iv = (ImageView) vh.getViewById(R.id.topic_rlv_item_iv);
        TextView topic_rlv_item_tv_name = (TextView) vh.getViewById(R.id.topic_rlv_item_tv_name);
        TextView topic_rlv_item_brif = (TextView) vh.getViewById(R.id.topic_rlv_item_brif);
        TextView topic_rlv_item_price = (TextView) vh.getViewById(R.id.topic_rlv_item_price);

        TxtUtils.setTextView(topic_rlv_item_tv_name, dataBean.getTitle());
        TxtUtils.setTextView(topic_rlv_item_brif, dataBean.getSubtitle());
        TxtUtils.setTextView(topic_rlv_item_price, dataBean.getPrice_info() + "元起");
        Glide.with(context).load(dataBean.getScene_pic_url()).into(topic_rlv_item_iv);
    }
}
