package com.example.very_good.model.home.address;

import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.address.AddressCityBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.address.IAddress;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;


public class AdddressCityModel extends BaseModel implements IAddress.Model {

    @Override
    public void getAddressCity(int parentId, Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService().getAddressCity(parentId)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<AddressCityBean>(callback) {
                            @Override
                            public void onNext(AddressCityBean addressCityBean) {
                                callback.success(addressCityBean);
                            }
                        })
        );
    }
}
