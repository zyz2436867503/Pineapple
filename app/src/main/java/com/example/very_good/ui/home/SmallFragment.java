package com.example.very_good.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.base.BaseFragment;
import com.example.very_good.bean.ChannelBean;
import com.example.very_good.bean.ChannelTypeBean;
import com.example.very_good.interfaces.home.IChannel;
import com.example.very_good.presenter.home.ChannelPre;
import com.example.very_good.ui.adpter.SmallAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SmallFragment extends BaseFragment<IChannel.ChannelP> implements IChannel.ChannelView {
    @BindView(R.id.ry_small)
    RecyclerView rySmall;
    @BindView(R.id.tv_cook)
    TextView tvCook;
    @BindView(R.id.tv_love)
    TextView tvLove;
    private int id;
    private SmallAdapter smallAdapter;
    private ArrayList<ChannelTypeBean.DataBeanX.DataBean> list;
    private String name;
    private String front_name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
        front_name = getArguments().getString("front_name");
    }

    @Override
    protected int getLayout() {
        return R.layout.smallfragment_item;
    }

    @Override
    protected IChannel.ChannelP createPrenter() {
        return new ChannelPre();
    }

    @Override
    protected void initView() {
        id = getArguments().getInt("id");
        tvCook.setText(name);
        tvLove.setText(front_name);
    }

    @Override
    protected void initData() {
        presenter.getChannelType(id, 1, 100);
    }

    @Override
    public void getChannelReturn(ChannelBean juJiaBean) {

    }

    @Override
    public void getChannelTypeReturn(ChannelTypeBean channelTypeBean) {
        InitSmall(channelTypeBean.getData().getData());
    }

    private void InitSmall(List<ChannelTypeBean.DataBeanX.DataBean> data) {

        Log.e("TAG", "InitSmall: " + data.get(0).getName());
        rySmall.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        list = new ArrayList<>();
        smallAdapter = new SmallAdapter(getActivity(), list);
        rySmall.setAdapter(smallAdapter);
        list.addAll(data);
        smallAdapter.notifyDataSetChanged();

        smallAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(mContext,LiveItemActivity.class);
                int id = data.get(pos).getId();
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }

    @Override
    public void tips(String tip) {

    }
}
