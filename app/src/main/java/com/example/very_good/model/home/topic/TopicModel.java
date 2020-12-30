package com.example.very_good.model.home.topic;


import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.topic.TopicBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.topic.ITopic;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

public class TopicModel extends BaseModel implements ITopic.Model {
    @Override
    public void getTopic(int page, Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService().getTopic(page)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<TopicBean>(callback) {
                    @Override
                    public void onNext(TopicBean topicBean) {
                        callback.success(topicBean);
                    }
                })
        );
    }
}
