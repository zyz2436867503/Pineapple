package com.example.very_good.model.home;

import com.example.very_good.api.ServiceApi;
import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.BrandBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.home.IBrand;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

public class BrandModel extends BaseModel implements IBrand.BrandMdodel {
    ServiceApi api;

    public BrandModel() {
        api = HttpManager.getInstance().getService();
    }

    @Override
    public void getbrandM(Callback callback) {
        addDisposible(api.getBrand().compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<BrandBean>(callback) {

            @Override
            public void onNext(BrandBean brandBean) {
                callback.success(brandBean);
            }
        }));
    }
}
