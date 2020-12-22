package com.example.very_good.interfaces.home;

import android.view.View;

import com.example.very_good.bean.CategoryBean;
import com.example.very_good.bean.CategoryBottomInfoBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

public interface ICategory {
    interface CateView extends IBaseView {
        //定义一个被实现的View层接口方法
        void getCategoryReturn(CategoryBean result);

        void getCategoryBottomInfoReturn(CategoryBottomInfoBean result);
    }

    interface CatePersenter extends IBasePresenter<CateView> {
        //定义一个V层调用的接口
        void getCategory(String id);

        void getCategoryBottomInfo(String id);
    }

    interface CateModel extends IBaseModel {
        //定义一个加载数据的接口方法   被P层
        void getCategory(String id, Callback callback);

        void getCategoryBottomInfo(String id,Callback callback);
    }
}
