package com.example.very_good.model.home;

import com.example.very_good.api.ServiceApi;
import com.example.very_good.base.BaseModel;

import com.example.very_good.bean.ChannelBean;
import com.example.very_good.bean.ChannelTypeBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.home.IChannel;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;


public class ChannelModel extends BaseModel implements IChannel.channelMo {
    ServiceApi api;

    public ChannelModel() {
        api = HttpManager.getInstance().getService();
    }

    @Override
    public void getChannel(Callback callback, int id) {
        addDisposible(api.getChannel(id).compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<ChannelBean>(callback) {

            @Override
            public void onNext(ChannelBean channelBean) {
                callback.success(channelBean);
            }
        }));
    }

    @Override
    public void getChannerType(Callback callback, int categoryId, int page, int size) {
        addDisposible(api.getChannelTree(categoryId, page, size).compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<ChannelTypeBean>(callback) {

            @Override
            public void onNext(ChannelTypeBean channelTypeBean) {
                callback.success(channelTypeBean);
            }
        }));
    }
}
