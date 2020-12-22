package com.example.very_good.model.home;

import com.example.very_good.api.ServiceApi;
import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.HomeBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.home.Ihome;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

public class HomeModel extends BaseModel implements Ihome.HomeModel {
    ServiceApi api;

    public HomeModel() {
        api = HttpManager.getInstance().getService();
    }

    @Override
    public void getHomeM(Callback callback) {


        addDisposible(api.getHome().compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeBean>(callback) {

                    @Override
                    public void onNext(HomeBean homeBean) {
                        callback.success(homeBean);
                    }
                })
        );
    }
}
