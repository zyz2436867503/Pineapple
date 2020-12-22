package com.example.very_good.interfaces.home;

import com.example.very_good.bean.ChannelBean;
import com.example.very_good.bean.ChannelTypeBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.IBaseModel;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.interfaces.IBaseView;

public interface IChannel {
    interface ChannelView extends IBaseView {
        void getChannelReturn(ChannelBean juJiaBean);
        void getChannelTypeReturn(ChannelTypeBean channelTypeBean);
    }

    interface channelMo extends IBaseModel {
        void getChannel(Callback callback, int id);
        void getChannerType(Callback callback,int categoryId,int page,int size);
    }

    interface ChannelP extends IBasePresenter<ChannelView> {
        void getChannel(int id);
        void getChannelType(int categoryId,int page,int size);
    }
}
