package com.example.very_good.presenter.home;

import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.CategoryBean;
import com.example.very_good.bean.CategoryBottomInfoBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.home.ICategory;
import com.example.very_good.model.home.CateModel;

public class CatePre extends BasePresenter<ICategory.CateView> implements ICategory.CatePersenter {
    ICategory.CateModel model;

    public CatePre() {
        this.model = model;
        model = new CateModel();
    }

    @Override
    public void getCategory(String id) {
        model.getCategory(id, new Callback() {
            @Override
            public void success(Object data) {
                mView.getCategoryReturn((CategoryBean) data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getCategoryBottomInfo(String id) {
        model.getCategoryBottomInfo(id, new Callback() {
            @Override
            public void success(Object data) {
                mView.getCategoryBottomInfoReturn((CategoryBottomInfoBean) data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
