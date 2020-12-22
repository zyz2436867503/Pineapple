package com.example.very_good.model.home;

import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.CategoryBean;
import com.example.very_good.bean.CategoryBottomInfoBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.home.ICategory;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

public class CateModel extends BaseModel implements ICategory.CateModel {
    @Override
    public void getCategory(String id, Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService().getCategory(id)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<CategoryBean>(callback) {
                            @Override
                            public void onNext(CategoryBean categoryBean) {
                                callback.success(categoryBean);
                            }
                        })
        );
    }

    @Override
    public void getCategoryBottomInfo(String id, Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService().getCategoryBottomInfo(id)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<CategoryBottomInfoBean>(callback) {
                            @Override
                            public void onNext(CategoryBottomInfoBean categoryBottomInfoBean) {
                                callback.success(categoryBottomInfoBean);
                            }
                        })
        );
    }
}
