package com.example.very_good.presenter.home.app;


import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.app.AppBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.app.IApp;
import com.example.very_good.model.home.app.AppModel;

public class AppPresenter extends BasePresenter<IApp.View> implements IApp.Presenter {

    IApp.Model model;

    public AppPresenter() {
        model = new AppModel();
    }

    @Override
    public void getAppInfo() {
        model.getAppInfo(new Callback<AppBean>() {
            @Override
            public void success(AppBean data) {
                if (mView != null) {
                    mView.getAppInfoReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
