package com.example.very_good.presenter.home.sort;


import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.sort.CatalogBean;
import com.example.very_good.bean.sort.CateRightBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.sort.ICataLog;
import com.example.very_good.model.home.sort.CatalogModel;

public class CataLogPre extends BasePresenter<ICataLog.CataLogView> implements ICataLog.CataLogPre {
    ICataLog.CataLogMdodel mdodel;

    public CataLogPre() {
        this.mdodel = new CatalogModel();
    }

    @Override
    public void getPre() {
        mdodel.getModel(new Callback() {
            @Override
            public void success(Object data) {
                mView.getView((CatalogBean) data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getRightPre(int id) {
        mdodel.getRightModel(id, new Callback() {
            @Override
            public void success(Object data) {
                mView.getRight((CateRightBean) data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
