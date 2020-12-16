package com.example.very_good.interfaces;

import io.reactivex.disposables.Disposable;

public interface IBaseModel {

    void addDisposible(Disposable disposable);

    void clear();

}
