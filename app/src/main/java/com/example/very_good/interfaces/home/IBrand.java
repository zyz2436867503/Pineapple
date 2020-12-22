package com.example.very_good.interfaces.home;

import com.example.very_good.bean.BrandBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

public interface IBrand {
    interface BrandView extends IBaseView {
        void getBrandReturn(BrandBean brandBean);
    }

    interface BrandMdodel extends IBaseModel {
        void getbrandM(Callback callback);
    }

    interface BeandPre extends IBasePresenter<BrandView> {
        void getbrandP();
    }
}
