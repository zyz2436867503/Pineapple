package com.example.very_good.presenter.home.login;

import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.login.LoginBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.login.ILogin;
import com.example.very_good.model.home.login.LoginModel;

public class LoginPre extends BasePresenter<ILogin.View> implements ILogin.Presenter {
    ILogin.Model model;
    public LoginPre(){
        model = new LoginModel();
    }
    @Override
    public void login(String username, String pw) {
        model.login(username, pw, new Callback() {
            @Override
            public void success(Object data) {
                if(mView != null){
                    mView.loginReturn((LoginBean) data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
