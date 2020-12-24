package com.example.very_good.model.home.register;


import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.register.RegisterBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.register.IRegist;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

public class RegistModel extends BaseModel implements IRegist.Model {
    @Override
    public void getMeRegist(String username, String password, Callback callback) {
        addDisposible(HttpManager.getInstance().getService().postRegister(username,password)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<RegisterBean>(callback) {
            @Override
            public void onNext(RegisterBean meRegisterBean) {
                callback.success(meRegisterBean);
            }
        }));
    }
}
