package com.example.very_good.interfaces.home;

import com.example.very_good.bean.NewListBean;
import com.example.very_good.bean.NewTopBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

import java.util.HashMap;

public interface INewGoods {
    interface NewView extends IBaseView {
        void getNewReturn(NewListBean newListBean);
        void getNewTop(NewTopBean newTopBean);
    }

    interface NewModel extends IBaseModel {
        void getNewModel(HashMap<String,String> map,Callback callback);
        void getNewTopM(Callback callback);

    }

    interface NewPre extends IBasePresenter<NewView> {
        void getNewPre(HashMap<String,String>map);
        void getNewTopP();
    }
}
