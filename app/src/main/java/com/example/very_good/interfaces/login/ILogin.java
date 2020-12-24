package com.example.very_good.interfaces.login;

import com.example.very_good.bean.login.LoginBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

public interface ILogin {
    interface View extends IBaseView {
        void loginReturn(LoginBean loginBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void login(String username,String pw);
    }


    interface Model extends IBaseModel {
        void login(String username,String pw, Callback callback);
    }

}
