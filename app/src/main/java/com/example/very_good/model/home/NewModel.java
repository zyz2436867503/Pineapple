package com.example.very_good.model.home;

import com.example.very_good.api.ServiceApi;
import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.BrandBean;
import com.example.very_good.bean.NewListBean;
import com.example.very_good.bean.NewTopBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.home.INewGoods;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

import java.util.HashMap;

public class NewModel extends BaseModel implements INewGoods.NewModel {
    ServiceApi api;

    public NewModel() {
        api = HttpManager.getInstance().getService();
    }

    @Override
    public void getNewModel(HashMap<String, String> map, Callback callback) {
        addDisposible(api.getNewGoodList(map).compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<NewListBean>(callback) {

            @Override
            public void onNext(NewListBean newListBean) {
                callback.success(newListBean);
            }
        }));
    }

    @Override
    public void getNewTopM(Callback callback) {
        addDisposible(api.getNewTop().compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<NewTopBean>(callback) {

            @Override
            public void onNext(NewTopBean newTopBean) {
                callback.success(newTopBean);
            }
        }));
    }
}