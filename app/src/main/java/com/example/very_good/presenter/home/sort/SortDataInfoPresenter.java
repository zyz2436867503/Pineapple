package com.example.very_good.presenter.home.sort;

import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.sort.Sort_Data_InfoBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.sort.ISortDataInfo;
import com.example.very_good.model.home.sort.SortDataInfoModel;

public class SortDataInfoPresenter extends BasePresenter<ISortDataInfo.View> implements ISortDataInfo.Persenter {

    ISortDataInfo.View view;
    ISortDataInfo.Model model;

    public SortDataInfoPresenter(ISortDataInfo.View view) {
        this.view = view;
        model = new SortDataInfoModel();
    }

    @Override
    public void getSortDataInfo(int id) {
        model.getSortDataInfo(id, new Callback() {
            @Override
            public void success(Object o) {
                if(view != null){
                    view.getSortDataInfoReturn((Sort_Data_InfoBean) o);
                }
            }

            @Override
            public void fail(String msg) {

            }
        });
    }
}
