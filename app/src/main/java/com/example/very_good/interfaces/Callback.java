package com.example.very_good.interfaces;

public interface Callback<T> {

    void success(T data);

    void fail(String err);

}
