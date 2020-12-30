package com.example.very_good.ui.adpter;

import android.content.Context;
import android.widget.ImageView;

import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.utils.ImageLoaderUtils;

import java.util.List;

public class CategoryBigImageAdapter extends BaseAdapter {
    public CategoryBigImageAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_category_bigimage_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        String bean = (String) data;

        ImageView img= (ImageView) vh.getViewById(R.id.iv_bigimage_img);
        ImageLoaderUtils.loadImage(bean,img);
    }
}
