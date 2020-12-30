package com.example.very_good.presenter.home.address;

import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.address.AddressCityBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.address.IAddress;
import com.example.very_good.model.home.address.AdddressCityModel;

public class AddressCityPresenter extends BasePresenter<IAddress.View> implements IAddress.Presenter {
    IAddress.Model model;

    public AddressCityPresenter() {
        model = new AdddressCityModel();
    }

    @Override
    public void getAddressCity(int parentId) {
        model.getAddressCity(parentId, new Callback() {
            @Override
            public void success(Object data) {
                mView.getAddressCityReturn((AddressCityBean) data);
            }

            @Override
            public void fail(String err) {

            }
        });

    }
}
