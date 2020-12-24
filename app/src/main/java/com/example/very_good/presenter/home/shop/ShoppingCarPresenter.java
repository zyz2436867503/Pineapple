package com.example.very_good.presenter.home.shop;


import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.shop.AddShoppingCarBean;
import com.example.very_good.bean.shop.DeleteShoppingCarBean;
import com.example.very_good.bean.shop.ShoppingCarBean;
import com.example.very_good.bean.shop.UpdateShoppingCarBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.shop.IShoppingCar;
import com.example.very_good.model.home.shop.ShoppingCarModel;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCarPresenter extends BasePresenter<IShoppingCar.View> implements IShoppingCar.Presenter {
    IShoppingCar.View view;
    IShoppingCar.Model model;

    public ShoppingCarPresenter(IShoppingCar.View view) {
        this.view = view;
        model = new ShoppingCarModel();
    }

    @Override
    public void getShoppingCar() {
        if (view != null) {
            model.getShoppingCar(new Callback() {
                @Override
                public void fail(String msg) {
                    view.tips(msg);
                }

                @Override
                public void success(Object o) {
                    view.getShoppingCarReturn((ShoppingCarBean) o);
                }
            });
        }
    }

    @Override
    public void postUpdateShoppingCar(Map<String, String> map) {
        if (view != null) {
            model.postUpdateShoppingCar(map, new Callback() {
                @Override
                public void fail(String msg) {
                    view.tips(msg);
                }

                @Override
                public void success(Object o) {
                    view.postUpdateShoppingCarReturn((UpdateShoppingCarBean) o);
                }
            });
        }
    }

    @Override
    public void postDeleteShoppingCar(String pIds) {
        if (view != null) {
            model.postDeleteShoppingCar(pIds, new Callback() {
                @Override
                public void fail(String msg) {
                    view.tips(msg);
                }

                @Override
                public void success(Object o) {
                    view.postDeleteShoppingCarReturn((DeleteShoppingCarBean) o);
                }
            });
        }
    }

    //添加购物车
    @Override
    public void AddShoppingCar(HashMap<String, String> map) {
        if (view != null) {
            model.AddShoppingCar(map, new Callback() {
                @Override
                public void fail(String msg) {
                    view.tips(msg);
                }

                @Override
                public void success(Object o) {
                    view.postAddShoppingCarReturn((AddShoppingCarBean) o);
                }
            });
        }
    }

}
