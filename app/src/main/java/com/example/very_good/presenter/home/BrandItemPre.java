package com.example.very_good.presenter.home;

import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.BrandItemBean;
import com.example.very_good.bean.BrandTopBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.home.IBrand;
import com.example.very_good.interfaces.home.IBrandItem;
import com.example.very_good.model.home.BrandItemModel;

public class BrandItemPre extends BasePresenter<IBrandItem.BrandItemView> implements IBrandItem.BrandItemPre {
    IBrandItem.BranItemModel model;

    public BrandItemPre() {
        this.model=new BrandItemModel();
    }

    @Override
    public void getTopP(int id) {
        model.getTopM(id, new Callback() {
            @Override
            public void success(Object data) {
                mView.getBrandTop((BrandTopBean) data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getItemP(int brandId, int page, int size) {
        model.getItemM(brandId, page, size, new Callback() {
            @Override
            public void success(Object data) {
                mView.getBrandItem((BrandItemBean) data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
