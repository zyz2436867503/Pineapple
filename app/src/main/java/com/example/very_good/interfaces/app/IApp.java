package com.example.very_good.interfaces.app;


import com.example.very_good.bean.app.AppBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

import java.util.Map;

public interface IApp {
    interface View extends IBaseView {
        void getAppInfoReturn(AppBean appBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getAppInfo();
    }


    interface Model extends IBaseModel {
        void getAppInfo(Callback callback);
    }
}
