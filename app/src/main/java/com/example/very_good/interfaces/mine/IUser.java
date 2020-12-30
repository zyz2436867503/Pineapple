package com.example.very_good.interfaces.mine;



import com.example.very_good.bean.mine.UserInfoBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

import java.util.Map;

public interface IUser {
    interface View extends IBaseView {
        void updateUserInfoReturn(UserInfoBean result);
    }

    interface Presenter extends IBasePresenter<View> {
        void updateUserInfo(Map<String, String> map);
    }


    interface Model extends IBaseModel {
        void updateUserInfo(Map<String, String> map, Callback callback);
    }
}
