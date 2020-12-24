package com.example.very_good.interfaces.shop;


import com.example.very_good.bean.shop.AddShoppingCarBean;
import com.example.very_good.bean.shop.DeleteShoppingCarBean;
import com.example.very_good.bean.shop.ShoppingCarBean;
import com.example.very_good.bean.shop.UpdateShoppingCarBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

import java.util.HashMap;
import java.util.Map;

public interface IShoppingCar {

    interface View extends IBaseView {
        //购物车列表
        void getShoppingCarReturn(ShoppingCarBean shoppingCarBean);

        //更新购物车的数据
        void postUpdateShoppingCarReturn(UpdateShoppingCarBean updateShoppingCarBean);

        //删除购物车数据
        void postDeleteShoppingCarReturn(DeleteShoppingCarBean deleteShoppingCarBean);

        //添加购物车
        void postAddShoppingCarReturn(AddShoppingCarBean rsult);
    }

    interface Presenter extends IBasePresenter<View> {
        //购物车列表
        void getShoppingCar();

        //更新购物车的数据
        void postUpdateShoppingCar(Map<String, String> map);

        //删除购物车数据
        void postDeleteShoppingCar(String pIds);

        //添加购物车
        void AddShoppingCar(HashMap<String, String> map);
    }

    interface Model extends IBaseModel {
        //购物车列表
        void getShoppingCar(Callback callback);

        //更新购物车的数据
        void postUpdateShoppingCar(Map<String, String> map, Callback callback);

        //删除购物车数据
        void postDeleteShoppingCar(String pIds, Callback callback);

        //添加购物车
        void AddShoppingCar(HashMap<String, String> map, Callback callback);
    }
}
