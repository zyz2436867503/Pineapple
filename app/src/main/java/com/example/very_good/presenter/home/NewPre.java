package com.example.very_good.presenter.home;

import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.NewListBean;
import com.example.very_good.bean.NewTopBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.home.INewGoods;
import com.example.very_good.model.home.NewModel;

import java.util.HashMap;

public class NewPre extends BasePresenter<INewGoods.NewView> implements INewGoods.NewPre {
    INewGoods.NewModel model;

    public NewPre() {
        this.model = new NewModel();
    }

    @Override
    public void getNewPre(HashMap<String, String> map) {
        model.getNewModel(map, new Callback() {
            @Override
            public void success(Object data) {
                mView.getNewReturn((NewListBean) data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getNewTopP() {
        model.getNewTopM(new Callback() {
            @Override
            public void success(Object data) {
                mView.getNewTop((NewTopBean) data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
