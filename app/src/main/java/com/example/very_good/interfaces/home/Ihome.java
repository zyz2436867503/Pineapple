package com.example.very_good.interfaces.home;

import com.example.very_good.bean.HomeBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

public interface Ihome {

    interface HomeView extends IBaseView {
        void getHomeReturn(HomeBean homeBean);
    }

    interface HomePresenter extends IBasePresenter<HomeView> {
        void getHomeP();
    }

    interface HomeModel extends IBaseModel {
        void getHomeM(Callback callback);

    }


}
