package com.example.very_good.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.very_good.R;
import com.example.very_good.base.BaseActivity;
import com.example.very_good.bean.ChannelBean;
import com.example.very_good.bean.ChannelTypeBean;
import com.example.very_good.interfaces.home.IChannel;
import com.example.very_good.presenter.home.ChannelPre;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChannelActivity extends BaseActivity<IChannel.ChannelP> implements IChannel.ChannelView {


    @BindView(R.id.tab_home)
    TabLayout tabHome;
    @BindView(R.id.vp_home)
    ViewPager vpHome;
    private int id = 1005000;

    @Override
    protected int getLayout() {
        return R.layout.channelactivity_item;
    }

    @Override
    protected IChannel.ChannelP createPrenter() {
        return new ChannelPre();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter.getChannel(id);
    }

    @Override
    public void getChannelReturn(ChannelBean juJiaBean) {
        List<ChannelBean.DataBean.BrotherCategoryBean> brotherCategory = juJiaBean.getData().getBrotherCategory();
        Intent intent = getIntent();
        id= intent.getIntExtra("id", 0);



        ArrayList<Fragment> fragment = new ArrayList<>();
        for (int i = 0; i < brotherCategory.size(); i++) {
            SmallFragment smallFragment = new SmallFragment();
            //获取id
            int id = brotherCategory.get(i).getId();
            String front_name = brotherCategory.get(i).getFront_name();
            String name = brotherCategory.get(i).getName();
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            bundle.putString("name",name);
            bundle.putString("front_name",front_name);
            smallFragment.setArguments(bundle);
            fragment.add(smallFragment);
        }
        vpHome.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragment.get(position);
            }

            @Override
            public int getCount() {
                return fragment.size();
            }
        });
        //tab和viewpager联动
        tabHome.setupWithViewPager(vpHome);
        for (int i = 0; i < brotherCategory.size(); i++) {
            String name = brotherCategory.get(i).getName();
            tabHome.getTabAt(i).setText(name);
        }

        String name = intent.getStringExtra("name");
        for (int i = 0; i < brotherCategory.size(); i++) {
            if(name.equals(brotherCategory.get(i).getName())){
                tabHome.getTabAt(i).select();
            }
        }
    }

    @Override
    public void getChannelTypeReturn(ChannelTypeBean channelTypeBean) {

    }

    @Override
    public void tips(String tip) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
