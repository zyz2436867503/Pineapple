package com.example.very_good.api;


import com.example.very_good.bean.HomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ServiceApi {
    String Home_URL = "https://cdplay.cn/";

    @GET("api/index")
    Flowable<HomeBean> getHome();

}
