package com.example.very_good.model.home.mine;


import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.mine.UserInfoBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.mine.IUser;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

import java.util.Map;

public class UserModel extends BaseModel implements IUser.Model {
    @Override
    public void updateUserInfo(Map<String, String> map, Callback callback) {
        addDisposible(HttpManager.getInstance().getService().updateUserInfo(map).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<UserInfoBean>(callback) {
                    @Override
                    public void onNext(UserInfoBean userInfoBean) {
                        callback.success(userInfoBean);
                    }
                }));
    }
}
