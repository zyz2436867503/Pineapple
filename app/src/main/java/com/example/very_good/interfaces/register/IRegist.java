package com.example.very_good.interfaces.register;


import com.example.very_good.bean.register.RegisterBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

//接口契约类
public interface IRegist {

    interface View extends IBaseView {
        //定义一个被实现的View层接口方法
        void getMeRegistReturn(RegisterBean result);
    }

    interface Persenter extends IBasePresenter<View> {
        //定义一个V层调用的接口
        void getMeRegist(String username, String password);
    }

    interface Model extends IBaseModel {
        //定义一个加载数据的接口方法   被P层
        void getMeRegist(String username, String password, Callback callback);
    }

}
