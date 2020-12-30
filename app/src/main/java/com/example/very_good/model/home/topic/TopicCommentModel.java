package com.example.very_good.model.home.topic;


import com.example.very_good.base.BaseModel;
import com.example.very_good.bean.topic.TopicCommentBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.topic.ITopicCommennt;
import com.example.very_good.net.CommonSubscriber;
import com.example.very_good.net.HttpManager;
import com.example.very_good.utils.RxUtils;

public class TopicCommentModel extends BaseModel implements ITopicCommennt.Model {
    @Override
    public void getTopicComment(int valueId, int typeId, int size, Callback callback) {
        addDisposible(HttpManager.getInstance().getService().getTopicComment(valueId,typeId,size)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<TopicCommentBean>(callback) {
            @Override
            public void onNext(TopicCommentBean topicCommentBean) {
                callback.success(topicCommentBean);
            }
        }));
    }
}
