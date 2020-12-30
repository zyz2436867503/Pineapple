package com.example.very_good.presenter.home.mine;


import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.mine.UserInfoBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.mine.IUser;
import com.example.very_good.model.home.mine.UserModel;

import java.util.Map;

public class UserPresenter extends BasePresenter<IUser.View> implements IUser.Presenter {

    IUser.Model model;

    public UserPresenter() {
        model = new UserModel();
    }

    @Override
    public void updateUserInfo(Map<String, String> map) {
        model.updateUserInfo(map, new Callback<UserInfoBean>() {
            @Override
            public void success(UserInfoBean data) {
                if (mView != null) {
                    mView.updateUserInfoReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

}
