package com.example.very_good.presenter.home.register;


import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.register.RegisterBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.register.IRegist;
import com.example.very_good.model.home.register.RegistModel;

public class RegistPresenter extends BasePresenter<IRegist.View> implements IRegist.Persenter {

    IRegist.Model model;

    public RegistPresenter() {
        model = new RegistModel();
    }

    @Override
    public void getMeRegist(String username, String password) {
        model.getMeRegist(username, password, new Callback() {
            @Override
            public void success(Object o) {
                if (mView != null) {
                    mView.getMeRegistReturn((RegisterBean) o);
                }
            }

            @Override
            public void fail(String msg) {

            }
        });
    }
}
