package com.example.very_good.interfaces.address;

import com.example.very_good.bean.address.AddressCityBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

public interface IAddress {
    //Address业务下的View
    interface View extends IBaseView {
        void getAddressCityReturn(AddressCityBean result);
    }
    //Address业务下的Presenter
    interface Presenter extends IBasePresenter<View> {
        void getAddressCity(int parentId);
    }

    //Address业务下的Model
    interface Model extends IBaseModel {
        void getAddressCity(int parentId, Callback callback);
    }
}
