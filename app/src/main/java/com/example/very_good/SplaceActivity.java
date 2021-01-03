package com.example.very_good;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.very_good.app.Constants;
import com.example.very_good.app.MyApp;
import com.example.very_good.base.BaseActivity;
import com.example.very_good.bean.app.AppBean;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.ui.start.SplaceFragment;
import com.example.very_good.utils.DownUtils;
import com.example.very_good.utils.SystemUtils;
import com.luck.picture.lib.tools.ToastUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

public class SplaceActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.img_1_normal)
    ImageView img_1_normal;
    @BindView(R.id.img_1_select)
    ImageView img_1_select;
    @BindView(R.id.img_2_normal)
    ImageView img_2_normal;
    @BindView(R.id.img_2_select)
    ImageView img_2_select;
    @BindView(R.id.img_3_normal)
    ImageView img_3_normal;
    @BindView(R.id.img_3_select)
    ImageView img_3_select;

    List<SplaceFragment> list;
    private boolean isUpdate;
    @Override
    protected int getLayout() {
        return R.layout.activity_splace;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        list.add(SplaceFragment.getInstance(1));
        list.add(SplaceFragment.getInstance(2));
        list.add(SplaceFragment.getInstance(3));
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetDots();
                if(position == 0){
                    img_1_normal.setVisibility(View.GONE);
                    img_1_select.setVisibility(View.VISIBLE);
                }else if(position == 1){
                    img_2_normal.setVisibility(View.GONE);
                    img_2_select.setVisibility(View.VISIBLE);
                }else if(position == 2){
                    img_3_normal.setVisibility(View.GONE);
                    img_3_select.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
       /* //获取最新的版本信息
        presenter.getAppInfo();*/
    }
    private void resetDots(){
        img_1_normal.setVisibility(View.VISIBLE);
        img_2_normal.setVisibility(View.VISIBLE);
        img_3_normal.setVisibility(View.VISIBLE);
        img_1_select.setVisibility(View.GONE);
        img_2_select.setVisibility(View.GONE);
        img_3_select.setVisibility(View.GONE);
    }

  /*  *//**
     * 版本信息
     * @param appBean
     *//*
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void getAppInfoReturn(AppBean appBean) {
        long versionCode = SystemUtils.getApkVersionCodeByPg(MyApp.app,appBean.getData().get(0).getPg());
        if(versionCode == -1){
            ToastUtils.s(this,"未找到对应的apk");
        }else{
            if(versionCode < appBean.getData().get(0).getVcode()){
                //下载更新apk
                isUpdate = true;
                list.get(2).isUpdate = true; //当前需要更新新版本
                downApk(appBean);
            }else{

            }
        }

    }
*/
  /*  @RequiresApi(api = Build.VERSION_CODES.R)
    private void downApk(AppBean appBean){
        String apkPath = Constants.APK_PATH+appBean.getData().get(0).getName();
        File file = new File(apkPath);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            DownUtils.downApk(appBean.getData().get(0).getUrl(), apkPath, new DownUtils.Callback() {
                @Override
                public void success() {
                    //安装apk
                    SystemUtils.installNewApk(apkPath);
                }

                @Override
                public void progress(String loading) {
                    txtLoading.post(new Runnable() {
                        @Override
                        public void run() {
                            txtLoading.setText(loading);
                        }
                    });
                }

                @Override
                public void fail(String err) {

                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }

    }*/

    class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

    @Override
    public void tips(String tip) {

    }
}