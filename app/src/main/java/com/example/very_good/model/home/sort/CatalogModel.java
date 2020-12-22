package com.example.very_good.model.home.sort;

import com.example.very_good.api.ServiceApi;
import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.sort.CatalogBean;
import com.example.very_good.bean.sort.CateRightBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.sort.ICataLog;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

public class CatalogModel extends BaseModel implements ICataLog.CataLogMdodel {
    ServiceApi api;

    public CatalogModel() {
        api = HttpManager.getInstance().getService();
    }

    @Override
    public void getModel(Callback callback) {
        addDisposible(api.getCataLog().compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<CatalogBean>(callback) {

            @Override
            public void onNext(CatalogBean result) {
                callback.success(result);
            }
        }));
    }

    @Override
    public void getRightModel(int id, Callback callback) {
        addDisposible(api.getCataRight(id).compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<CateRightBean>(callback) {

            @Override
            public void onNext(CateRightBean result) {
                callback.success(result);
            }
        }));
    }
}
