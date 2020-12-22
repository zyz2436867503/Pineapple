package com.example.very_good.presenter.home;

import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.ChannelBean;
import com.example.very_good.bean.ChannelTypeBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.home.IChannel;
import com.example.very_good.model.home.ChannelModel;

public class ChannelPre extends BasePresenter<IChannel.ChannelView> implements IChannel.ChannelP {
    IChannel.channelMo mo;

    public ChannelPre() {
        this.mo = new ChannelModel();
    }

    @Override
    public void getChannel(int id) {
        mo.getChannel(new Callback() {
            @Override
            public void success(Object data) {
                mView.getChannelReturn((ChannelBean) data);
            }

            @Override
            public void fail(String err) {

            }
        }, id);

    }

    @Override
    public void getChannelType(int categoryId, int page, int size) {
        mo.getChannerType(new Callback() {
            @Override
            public void success(Object data) {
                mView.getChannelTypeReturn((ChannelTypeBean) data);
            }

            @Override
            public void fail(String err) {

            }
        }, categoryId, page, size);
    }
}
