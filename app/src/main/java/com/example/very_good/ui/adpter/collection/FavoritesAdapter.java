package com.example.very_good.ui.adpter.collection;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.ui.collection.Favorites;
import com.example.very_good.utils.ImageLoaderUtils;

import java.util.List;

public class FavoritesAdapter extends BaseAdapter<Favorites> {
    public FavoritesAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.favor_adapter;
    }

    @Override
    protected void bindData(Favorites data, VH vh) {
        TextView tvfavoritesname = (TextView) vh.getViewById(R.id.tv_favorites_name);
        TextView tvfavoritestitle = (TextView) vh.getViewById(R.id.tv_favorites_title);
        TextView tvfavoritesprice = (TextView) vh.getViewById(R.id.tv_favorites_price);
        ImageView ivfavoritespic = (ImageView) vh.getViewById(R.id.iv_favorites_pic);

        tvfavoritesname.setText(data.getName());
        tvfavoritesprice.setText("￥"+data.getPrice());
        tvfavoritestitle.setText(data.getTitle());
        ImageLoaderUtils.loadImage(data.getPic(),ivfavoritespic);
    }
}
