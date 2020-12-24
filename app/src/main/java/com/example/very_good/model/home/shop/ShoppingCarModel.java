package com.example.very_good.model.home.shop;


import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.shop.AddShoppingCarBean;
import com.example.very_good.bean.shop.DeleteShoppingCarBean;
import com.example.very_good.bean.shop.ShoppingCarBean;
import com.example.very_good.bean.shop.UpdateShoppingCarBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.shop.IShoppingCar;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCarModel extends BaseModel implements IShoppingCar.Model {

    @Override
    public void getShoppingCar(Callback callback) {
        addDisposible(HttpManager.getInstance().getService().getShoppingCar()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ShoppingCarBean>(callback) {
                    @Override
                    public void onNext(ShoppingCarBean shoppingCarBean) {
                        callback.success(shoppingCarBean);
                    }
                }));
    }

    @Override
    public void postUpdateShoppingCar(Map<String, String> map, Callback callback) {
        addDisposible(HttpManager.getInstance().getService().postUpdateShoppingCar(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<UpdateShoppingCarBean>(callback) {
                    @Override
                    public void onNext(UpdateShoppingCarBean updateShoppingCarBean) {
                        callback.success(updateShoppingCarBean);
                    }
                }));
    }

    @Override
    public void postDeleteShoppingCar(String pIds, Callback callback) {
        addDisposible(HttpManager.getInstance().getService().postDeleteShoppingCar(pIds)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<DeleteShoppingCarBean>(callback) {
                    @Override
                    public void onNext(DeleteShoppingCarBean deleteShoppingCarBean) {
                        callback.success(deleteShoppingCarBean);
                    }
                }));
    }

    //购物车
    @Override
    public void AddShoppingCar(HashMap<String, String> map, Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService().postAddShoppingCar(map)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<AddShoppingCarBean>(callback) {
                            @Override
                            public void onNext(AddShoppingCarBean addShoppingCarBean) {
                                callback.success(addShoppingCarBean);
                            }
                        })
        );
    }
}
