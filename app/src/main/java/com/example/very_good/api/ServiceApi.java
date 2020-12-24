package com.example.very_good.api;


import com.example.very_good.bean.BrandBean;
import com.example.very_good.bean.BrandItemBean;
import com.example.very_good.bean.BrandTopBean;
import com.example.very_good.bean.CategoryBean;
import com.example.very_good.bean.CategoryBottomInfoBean;
import com.example.very_good.bean.ChannelTypeBean;
import com.example.very_good.bean.HomeBean;
import com.example.very_good.bean.ChannelBean;
import com.example.very_good.bean.NewListBean;
import com.example.very_good.bean.NewTopBean;
import com.example.very_good.bean.login.LoginBean;
import com.example.very_good.bean.register.RegisterBean;
import com.example.very_good.bean.shop.AddShoppingCarBean;
import com.example.very_good.bean.shop.DeleteShoppingCarBean;
import com.example.very_good.bean.shop.ShoppingCarBean;
import com.example.very_good.bean.shop.UpdateShoppingCarBean;
import com.example.very_good.bean.sort.CatalogBean;
import com.example.very_good.bean.sort.CateRightBean;
import com.example.very_good.bean.sort.Sort_Data_InfoBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ServiceApi {
    String Home_URL = "https://cdplay.cn/";

    //首页
    @GET("api/index")
    Flowable<HomeBean> getHome();

    //channel(居家...)分类
    //https://cdplay.cn/goods/category?id=1005000
    @GET("goods/category?")
    Flowable<ChannelBean> getChannel(@Query("id") int id);


    //分类数据  1005007 1 100
    //https://cdplay.cn/api/goods/list?categoryId=1005000&page=1&size=100
    @GET("api/goods/list?")
    Flowable<ChannelTypeBean> getChannelTree(@Query("categoryId") int categoryId, @Query("page") int page, @Query("size") int size);

    //品牌制造商列表
    //https://cdplay.cn/api/brand/list?page=1&size=1000
    @GET("api/brand/list?page=1&size=1000")
    Flowable<BrandBean> getBrand();


    //制造商详情页商品列表的数据上图片
    //https://cdplay.cn/api/brand/detail?id=1001000
    @GET("brand/detail")
    Flowable<BrandTopBean> getHomeBrandInfoTop(@Query("id") int id);


    //制造商详情页商品列表的数据接口
    //https://cdplay.cn/api/goods/list?brandId=1001000&page=1&size=1000
    @GET("/api/goods/list")
    Flowable<BrandItemBean> getBrandBigItem(@Query("brandId") int brandId, @Query("page") int page, @Query("size") int size);

    //https://cdplay.cn/api/goods/hot
    @GET("api/goods/hot")
    Flowable<NewTopBean> getNewTop();

    //新品发布的条件筛选数据接口
    @GET("api/goods/list")
    Flowable<NewListBean> getNewGoodList(@QueryMap HashMap<String, String> map);


    //居家.....等详情接口
    @GET("api/goods/detail")
//居家 商品详情购买页
    Flowable<CategoryBean> getCategory(@Query("id") String id);

    //商品 详情购买页 底部数据列表 api/goods/related?id=1155000
    @GET("api/goods/related")
    Flowable<CategoryBottomInfoBean> getCategoryBottomInfo(@Query("id") String id);

    //https://cdplay.cn/api/catalog/index  分类竖着导航栏
    @GET("api/catalog/index")
    Flowable<CatalogBean> getCataLog();

    //https://cdplay.cn/api/catalog/current?id=1005001
    @GET("catalog/current?")
    Flowable<CateRightBean> getCataRight(@Query("id") int id);


    //分类右边数据点击详情
    @GET("goods/category")
    Flowable<Sort_Data_InfoBean> getSortDataInfo(@Query("id") int id);

    //用户登录
    @POST("api/auth/login")
    @FormUrlEncoded
    Flowable<LoginBean> postLogin(@Field("username") String username, @Field("password") String pw);

    //用户注册
    @POST("api/auth/register")
    @FormUrlEncoded
    Flowable<RegisterBean> postRegister(@Field("username") String username, @Field("password") String pw);

    //添加到购物车
    @POST("api/cart/add")
    @FormUrlEncoded
    Flowable<AddShoppingCarBean> postAddShoppingCar(@FieldMap HashMap<String, String> map);

    //购物车列表
    @GET("api/cart/index")
    Flowable<ShoppingCarBean> getShoppingCar();

    //更新购物车的数据
    @POST("api/cart/update")//  goodsId=1035006 number=1   productId=47     // 1116033   1   171
    @FormUrlEncoded
    Flowable<UpdateShoppingCarBean> postUpdateShoppingCar(@FieldMap Map<String, String> map);

    //删除购物车数据
    @POST("api/cart/delete")
    @FormUrlEncoded
    Flowable<DeleteShoppingCarBean> postDeleteShoppingCar(@Field("productIds") String productIds);



}
