package com.example.very_good.presenter.home;

import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.BrandBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.home.IBrand;
import com.example.very_good.model.home.BrandModel;

public class BrandP extends BasePresenter<IBrand.BrandView> implements IBrand.BeandPre {
    IBrand.BrandMdodel mdodel;

    public BrandP() {
        this.mdodel = new BrandModel();
    }

    @Override
    public void getbrandP() {
        mdodel.getbrandM(new Callback() {
            @Override
            public void success(Object data) {
                mView.getBrandReturn((BrandBean) data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
