package com.example.very_good.model.home;


import com.example.very_good.api.ServiceApi;
import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.BrandItemBean;
import com.example.very_good.bean.BrandTopBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.home.IBrandItem;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

public class BrandItemModel extends BaseModel implements IBrandItem.BranItemModel {
    ServiceApi api;

    public BrandItemModel() {
        api = HttpManager.getInstance().getService();
    }

    @Override
    public void getTopM(int id, Callback callback) {
        addDisposible(api.getHomeBrandInfoTop(id).compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<BrandTopBean>(callback) {

            @Override
            public void onNext(BrandTopBean brandTopBean) {
                callback.success(brandTopBean);
            }
        }));
    }

    @Override
    public void getItemM(int brandId, int page, int size, Callback callback) {
        addDisposible(api.getBrandBigItem(brandId, page, size).compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<BrandItemBean>(callback) {

            @Override
            public void onNext(BrandItemBean brandItemBean) {
                callback.success(brandItemBean);
            }
        }));
    }
}
