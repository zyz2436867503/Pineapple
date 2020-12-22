package com.example.very_good.ui.sort;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.very_good.R;
import com.example.very_good.base.BaseActivity;
import com.example.very_good.bean.sort.Sort_Data_InfoBean;
import com.example.very_good.interfaces.sort.ISortDataInfo;
import com.example.very_good.presenter.home.sort.SortDataInfoPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SortItemActivity extends BaseActivity<ISortDataInfo.Persenter> implements ISortDataInfo.View {

    @BindView(R.id.tab_home)
    TabLayout tabHome;
    @BindView(R.id.vp_home)
    ViewPager vpHome;
    private int id1;
    private Intent intent;

    @Override
    protected int getLayout() {
        return R.layout.sortitem_layout;
    }

    @Override
    protected ISortDataInfo.Persenter createPrenter() {
        return new SortDataInfoPresenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        intent = getIntent();
        id1 = intent.getIntExtra("id", 0);

        presenter.getSortDataInfo(id1);

    }

    @Override
    public void getSortDataInfoReturn(Sort_Data_InfoBean result) {


        List<Sort_Data_InfoBean.DataBean.BrotherCategoryBean> brotherCategory = result.getData().getBrotherCategory();
        ArrayList<Fragment> fragment = new ArrayList<>();
        for (int i = 0; i < brotherCategory.size(); i++) {
            SortItemFragment sortItemFragment = new SortItemFragment();
            //获取id
            String front_name = brotherCategory.get(i).getFront_name();
            int id = brotherCategory.get(i).getId();
            String name = brotherCategory.get(i).getName();
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            bundle.putString("name", name);
            bundle.putString("front_name", front_name);
            sortItemFragment.setArguments(bundle);
            fragment.add(sortItemFragment);
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
            if (name.equals(brotherCategory.get(i).getName())) {
                tabHome.getTabAt(i).select();
            }
        }
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
