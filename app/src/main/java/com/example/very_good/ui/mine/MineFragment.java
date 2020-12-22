package com.example.very_good.ui.mine;

import com.example.very_good.R;
import com.example.very_good.base.BaseFragment;
import com.example.very_good.bean.HomeBean;
import com.example.very_good.interfaces.home.Ihome;

public class MineFragment extends BaseFragment<Ihome.HomePresenter>implements Ihome.HomeView {
    @Override
    protected int getLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    protected Ihome.HomePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void getHomeReturn(HomeBean homeBean) {

    }

    @Override
    public void tips(String tip) {

    }
}
