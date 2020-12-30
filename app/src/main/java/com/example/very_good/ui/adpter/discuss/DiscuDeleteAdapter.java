package com.example.very_good.ui.adpter.discuss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;

import java.util.ArrayList;

public class DiscuDeleteAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<String> list;

    public DiscuDeleteAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.rlv_ping_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        String s = list.get(position);
        Glide.with(context).load(s).into(viewHolder.img_pic);
        viewHolder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ionClick.onclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img_pic;
        public ImageView img_delete;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_pic = (ImageView) rootView.findViewById(R.id.iv_jia);
            this.img_delete = (ImageView) rootView.findViewById(R.id.iv_delete);
        }

    }
    public interface IonClick{
        void onclick(int pos);
    }
    IonClick ionClick;

    public void setIonClick(IonClick ionClick) {
        this.ionClick = ionClick;
    }
}
