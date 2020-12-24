package com.example.very_good.ui.sort;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.very_good.R;
import com.example.very_good.base.BaseFragment;
import com.example.very_good.bean.sort.Sort_Data_InfoBean;
import com.example.very_good.interfaces.sort.ISortDataInfo;
import com.example.very_good.presenter.home.sort.SortDataInfoPresenter;
import com.example.very_good.ui.adpter.sort.SortItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class SortItemFragment extends BaseFragment<ISortDataInfo.Persenter> implements ISortDataInfo.View {
    @BindView(R.id.tv_cook)
    TextView tvCook;
    @BindView(R.id.tv_love)
    TextView tvLove;
    @BindView(R.id.ry_small)
    RecyclerView rySmall;
    private String name;
    private String front_name;
    private int id;
    private ArrayList<Sort_Data_InfoBean.DataBean.BrotherCategoryBean> list;
    private SortItemAdapter sortItemAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
        front_name = getArguments().getString("front_name");
    }

    @Override
    protected int getLayout() {
        return R.layout.smallfragment_item;
    }

    @Override
    protected ISortDataInfo.Persenter createPrenter() {
        return new SortDataInfoPresenter(this);
    }

    @Override
    protected void initView() {

        tvCook.setText(name);
        tvLove.setText(front_name);
    }

    @Override
    protected void initData() {
        id = getArguments().getInt("id");
        presenter.getSortDataInfo(id);
    }

    @Override
    public void getSortDataInfoReturn(Sort_Data_InfoBean result) {
        List<Sort_Data_InfoBean.DataBean.BrotherCategoryBean> brotherCategory = result.getData().getBrotherCategory();
        rySmall.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        list = new ArrayList<>();

        sortItemAdapter = new SortItemAdapter(getActivity(), list);
        rySmall.setAdapter(sortItemAdapter);
        list.addAll(brotherCategory);
        sortItemAdapter.notifyDataSetChanged();
    }

    @Override
    public void tips(String tip) {

    }
}
