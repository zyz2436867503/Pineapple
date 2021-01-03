package com.example.very_good.model.home.app;

import android.util.Log;


import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.app.AppBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.app.IApp;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

public class AppModel extends BaseModel implements IApp.Model {
    @Override
    public void getAppInfo(Callback callback) {
        addDisposible(HttpManager.getInstance().getService().getAppInfo().
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AppBean>(callback) {
                    @Override
                    public void onNext(AppBean appBean) {
                        Log.i("TAG", "model onNext register");
                        callback.success(appBean);
                    }
                }));
    }
}
