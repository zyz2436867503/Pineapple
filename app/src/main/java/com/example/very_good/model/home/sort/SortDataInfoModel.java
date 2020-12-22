package com.example.very_good.model.home.sort;


import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.sort.Sort_Data_InfoBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.sort.ISortDataInfo;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

public class SortDataInfoModel extends BaseModel implements ISortDataInfo.Model {
    @Override
    public void getSortDataInfo(int id, Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService().getSortDataInfo(id)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<Sort_Data_InfoBean>(callback) {
                    @Override
                    public void onNext(Sort_Data_InfoBean sort_data_infoBean) {
                        callback.success(sort_data_infoBean);
                    }
                })
        );
    }
}
