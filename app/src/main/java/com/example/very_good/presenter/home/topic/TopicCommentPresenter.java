package com.example.very_good.presenter.home.topic;


import com.example.very_good.base.BasePresenter;
import com.example.very_good.bean.topic.TopicCommentBean;
import com.example.very_good.interfaces.Callback;
import com.example.very_good.interfaces.topic.ITopicCommennt;
import com.example.very_good.model.home.topic.TopicCommentModel;

public class TopicCommentPresenter extends BasePresenter<ITopicCommennt.View> implements ITopicCommennt.Persenter {

    ITopicCommennt.View view;
    ITopicCommennt.Model model;

    public TopicCommentPresenter(ITopicCommennt.View view) {
        this.view = view;
        model = new TopicCommentModel();
    }

    @Override
    public void getTopicComment(int valueId, int typeId, int size) {
        model.getTopicComment(valueId, typeId, size, new Callback() {
            @Override
            public void success(Object o) {
                if(view != null){
                    view.getTopicCommentReturn((TopicCommentBean) o);
                }
            }

            @Override
            public void fail(String msg) {

            }
        });
    }
}
