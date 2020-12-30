package com.example.very_good.presenter.home.topic;


import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.topic.TopicBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.topic.ITopic;
import com.example.very_good.model.home.topic.TopicModel;

public class TopicPresenter extends BasePresenter<ITopic.View> implements ITopic.Persenter  {

    ITopic.Model model;
    ITopic.View view;

    public TopicPresenter(ITopic.View view) {
        this.view = view;
        model = new TopicModel();
    }

    @Override
    public void getTopic(int page) {
        model.getTopic(page, new Callback() {
            @Override
            public void success(Object o) {
                if(view != null) {
                    view.getTopicReturn((TopicBean) o);
                }
            }
            @Override
            public void fail(String msg) {

            }
        });
    }
}
