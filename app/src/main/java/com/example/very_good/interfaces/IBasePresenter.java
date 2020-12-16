package com.example.very_good.interfaces;

public interface IBasePresenter<V extends IBaseView> {

    void attachView(V view);

    void unAttachView();

}
