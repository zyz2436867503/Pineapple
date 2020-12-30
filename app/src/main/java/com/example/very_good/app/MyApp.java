package com.example.very_good.app;

import android.app.Application;

import java.util.HashMap;


public class MyApp extends Application {
    public static HashMap<String, Object> map;
    public static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        map = new HashMap<>();
    }
    public static HashMap<String, Object> getMap() {
        return map;
    }
}
