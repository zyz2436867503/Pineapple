package com.example.very_good.interfaces.sort;

import com.example.very_good.bean.sort.CatalogBean;
import com.example.very_good.bean.sort.CateRightBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

public interface ICataLog {
    interface CataLogView extends IBaseView {
        void getView(CatalogBean result);
        void getRight(CateRightBean result);
    }

    interface CataLogMdodel extends IBaseModel {
        void getModel(Callback callback);
        void getRightModel(int id,Callback callback);
    }

    interface CataLogPre extends IBasePresenter<CataLogView> {
        void getPre();
        void getRightPre(int id);
    }
}
