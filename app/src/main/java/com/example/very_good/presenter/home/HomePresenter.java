package com.example.very_good.presenter.home;
import com.example.very_good.base.BasePresenter;

import com.example.very_good.bean.HomeBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.home.Ihome;
import com.example.very_good.model.home.HomeModel;


public class HomePresenter extends BasePresenter<Ihome.HomeView> implements Ihome.HomePresenter {

    Ihome.HomeModel model;

    public HomePresenter() {
        model = new HomeModel();
    }

    @Override
    public void getHomeP() {
        model.getHomeM(new Callback() {
            @Override
            public void success(Object data) {
                if (mView != null) {
                    mView.getHomeReturn((HomeBean) data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
