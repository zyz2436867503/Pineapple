package com.example.very_good.interfaces.home;

import com.example.very_good.bean.BrandItemBean;
import com.example.very_good.bean.BrandTopBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

public interface IBrandItem {
    interface BrandItemView extends IBaseView {
        void getBrandTop(BrandTopBean brandItemTopBean);

        void getBrandItem(BrandItemBean brandItemBean);
    }

    interface BranItemModel extends IBaseModel {
        void getTopM(int id, Callback callback);

        void getItemM(int brandId, int page, int size,Callback callback);
    }

    interface BrandItemPre extends IBasePresenter<BrandItemView> {
        void getTopP(int id);

        void getItemP(int brandId, int page, int size);
    }

}
