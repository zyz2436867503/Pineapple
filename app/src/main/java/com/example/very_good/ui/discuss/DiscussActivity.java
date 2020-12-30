package com.example.very_good.ui.discuss;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.very_good.R;
import com.example.very_good.app.Constants;
import com.example.very_good.bean.mine.UserInfoBean;
import com.example.very_good.ui.adpter.discuss.DiscuDeleteAdapter;
import com.example.very_good.ui.adpter.discuss.DiscussAdapter;
import com.example.very_good.utils.BitmapUtils;
import com.example.very_good.utils.GlideEngine;
import com.example.very_good.utils.SpUtils;
import com.example.very_good.utils.SystemUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DiscussActivity extends AppCompatActivity {

    @BindView(R.id.tv_cancle)
    TextView tvCancle;
    @BindView(R.id.tv_send)
    TextView tvSend;
    @BindView(R.id.con_head)
    ConstraintLayout conHead;
    @BindView(R.id.et_thing)
    EditText etThing;
    @BindView(R.id.ry_img)
    RecyclerView ryImg;
    @BindView(R.id.iv_jia)
    ImageView ivJia;
    private Unbinder bind;
    private ArrayList<String> list;
    private int number;
    private DiscuDeleteAdapter discuDeleteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discuss);
        bind = ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        ryImg.setLayoutManager(new GridLayoutManager(this, 3));
        list = new ArrayList<>();
        discuDeleteAdapter = new DiscuDeleteAdapter(this, list);
        ryImg.setAdapter(discuDeleteAdapter);
        discuDeleteAdapter.notifyDataSetChanged();

        discuDeleteAdapter.setIonClick(new DiscuDeleteAdapter.IonClick() {
            @Override
            public void onclick(int pos) {
                list.remove(pos);
                discuDeleteAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @OnClick({R.id.tv_cancle, R.id.tv_send, R.id.iv_jia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancle:
                break;
            case R.id.tv_send:
                break;
            case R.id.iv_jia:
                openPhoto();
                break;
        }
    }

    private void openPhoto() {
        number = 9 - list.size();
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine()) // Please refer to the Demo GlideEngine.java
                .maxSelectNum(number)
                .imageSpanCount(4)
                .selectionMode(PictureConfig.MULTIPLE)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureConfig.CHOOSE_REQUEST:
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                if (selectList.size() == 0) return;


                //把选中的图片插入到列表

                for (int i = 0; i < selectList.size(); i++) {
                    list.add(selectList.get(i).getPath());
                }
                discuDeleteAdapter.notifyDataSetChanged();

                if (list.size() == 9) {
                    ivJia.setVisibility(View.GONE);
                }else {
                    ivJia.setVisibility(View.VISIBLE);
                }

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);

        }
    }


}