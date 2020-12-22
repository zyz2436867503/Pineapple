package com.example.very_good.ui.sort;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import androidx.viewpager.widget.ViewPager;

import com.example.very_good.R;
import com.example.very_good.base.BaseFragment;
import com.example.very_good.bean.sort.CatalogBean;
import com.example.very_good.bean.sort.CateRightBean;
import com.example.very_good.interfaces.sort.ICataLog;
import com.example.very_good.presenter.home.sort.CataLogPre;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;


public class SortFragment extends BaseFragment<ICataLog.CataLogPre> implements ICataLog.CataLogView {


    @BindView(R.id.tab)
    VerticalTabLayout mtab;
    @BindView(R.id.vp)
    ViewPager vp;



    @Override
    protected int getLayout() {
        return R.layout.sortfragment_layout;
    }

    @Override
    protected ICataLog.CataLogPre createPrenter() {
        return new CataLogPre();
    }

    @Override
    protected void initView() {
    }


    @Override
    protected void initData() {
        presenter.getPre();


    }

    //todo 分类竖着导航栏
    @Override
    public void getView(CatalogBean result) {
        //获取集合
        List<CatalogBean.DataBean.CategoryListBean> categoryList = result.getData().getCategoryList();
        ArrayList<Fragment> fragment = new ArrayList<>();
        //遍历传值
        for (int i = 0; i <categoryList.size(); i++) {
            SortCataFragment sortCataFragment = new SortCataFragment();
            //获取id
            int id = categoryList.get(i).getId();
            Bundle bundle = new Bundle();
            bundle.putInt("id",id);
            sortCataFragment.setArguments(bundle);
            fragment.add(sortCataFragment);
        }

        mtab.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return fragment.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public QTabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public QTabView.TabTitle getTitle(int position) {
                return null;
            }

            @Override
            public int getBackground(int position) {
                return R.drawable.tab_selector;//选中的背景颜色
            }
        });

        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
        mtab.setupWithViewPager(vp);
        for (int i = 0; i < categoryList.size(); i++) {
            String name = categoryList.get(i).getName();
            mtab.getTabAt(i).getTitleView().setText(name);

        }


    }

    @Override
    public void getRight(CateRightBean result) {

    }

    @Override
    public void tips(String tip) {

    }
}
