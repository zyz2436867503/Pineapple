package com.example.very_good.ui.sort;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.base.BaseFragment;
import com.example.very_good.bean.sort.CatalogBean;
import com.example.very_good.bean.sort.CateRightBean;
import com.example.very_good.interfaces.sort.ICataLog;
import com.example.very_good.presenter.home.sort.CataLogPre;
import com.example.very_good.ui.adpter.sort.SortCataAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SortCataFragment extends BaseFragment<ICataLog.CataLogPre> implements ICataLog.CataLogView {


    @BindView(R.id.iv_sort)
    ImageView ivSort;
    @BindView(R.id.tv_sort)
    TextView tvSort;
    @BindView(R.id.ry_sort)
    RecyclerView rySort;
    @BindView(R.id.tv_tiitle)
    TextView tvTiitle;
    private int id;
    private SortCataAdapter sortCataAdapter;

    @Override
    protected int getLayout() {
        return R.layout.sortcata_layout;
    }

    @Override
    protected ICataLog.CataLogPre createPrenter() {
        return new CataLogPre();
    }

    @Override
    protected void initView() {
        id = getArguments().getInt("id");

    }

    @Override
    protected void initData() {
        presenter.getRightPre(id);
    }

    @Override
    public void getView(CatalogBean result) {

    }

    @Override
    public void getRight(CateRightBean result) {

        CateRightBean.DataBean.CurrentCategoryBean currentCategory = result.getData().getCurrentCategory();
        Glide.with(getActivity()).load(currentCategory.getWap_banner_url()).into(ivSort);

        tvTiitle.setText(currentCategory.getFront_name());
        tvSort.setText("——" + currentCategory.getName() + "分类" + "——");

        List<CateRightBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = result.getData().getCurrentCategory().getSubCategoryList();
        ArrayList<CateRightBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list = new ArrayList<>();
        rySort.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        sortCataAdapter = new SortCataAdapter(getActivity(), list);
        rySort.setAdapter(sortCataAdapter);
        list.addAll(subCategoryList);
        sortCataAdapter.notifyDataSetChanged();

        sortCataAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(getActivity(), SortItemActivity.class);
                intent.putExtra("id", list.get(pos).getId());
                intent.putExtra("name", list.get(pos).getName());
                startActivity(intent);
            }
        });

    }

    @Override
    public void tips(String tip) {

    }
}
