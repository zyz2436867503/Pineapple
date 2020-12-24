package com.example.very_good.model.home.login;

import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.login.LoginBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.login.ILogin;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

public class LoginModel extends BaseModel implements ILogin.Model {
    @Override
    public void login(String username, String pw, Callback callback) {
        addDisposible(HttpManager.getInstance().getService().postLogin(username, pw).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<LoginBean>(callback) {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        callback.success(loginBean);
                    }
                }));
    }
}
