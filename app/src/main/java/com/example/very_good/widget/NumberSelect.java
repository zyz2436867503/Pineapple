package com.example.very_good.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.very_good.R;


public class NumberSelect extends LinearLayout implements View.OnClickListener{
    private TextView txtReduce, txtNumber, txtAdd;
    private int number; //当前的数字
    private ChangeNumber changeNumber;

    public int getNumber() {
        return number;
    }

    public void addChangeNumber(ChangeNumber changeNumber) {
        this.changeNumber = changeNumber;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public NumberSelect(Context context) {
        super(context);
    }

    public NumberSelect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberSelect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void addPage(int layout) {
        removeAllViews();
        View view = LayoutInflater.from(getContext()).inflate(layout, this, false);
        addView(view);
        txtReduce = view.findViewById(R.id.txt_reduce);
        txtNumber = view.findViewById(R.id.txt_number);
        txtAdd = view.findViewById(R.id.txt_add);
        initTxtNumber();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_reduce://减少数量
                numberReduce();
                break;
            case R.id.txt_add://添加数量
                numberAdd();//对数量进行修改
                break;
        }
    }

    private void numberAdd() {
        number++;
        txtNumber.setText(String.valueOf(number));
        if (changeNumber != null) {
            changeNumber.change(number);
        }
    }

    private void numberReduce() {
        number--;
        number = number <= 0 ? 1 : number;
        txtNumber.setText(String.valueOf(number));
        if (changeNumber != null) {
            changeNumber.change(number);
        }

    }
    //对数量进行修改
    private void initTxtNumber() {
        if(txtNumber != null){
            txtNumber.setText(String.valueOf(getNumber()));
        }
    }

    /**
     * 接口回调
     */
    public interface ChangeNumber {
        void change(int number);
    }
}
