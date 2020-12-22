package com.example.very_good.ui.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.base.BaseActivity;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.bean.NewListBean;
import com.example.very_good.bean.NewTopBean;
import com.example.very_good.interfaces.home.INewGoods;
import com.example.very_good.presenter.home.NewPre;
import com.example.very_good.ui.adpter.NewGoodAdapter;
import com.example.very_good.ui.adpter.SortAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewGoodsActivity extends BaseActivity<INewGoods.NewPre> implements INewGoods.NewView {
    private static final String ASC = "asc";
    private static final String DESC = "desc";
    private static final String DEFAULT = "default";
    private static final String PRICE = "price";
    private static final String CATEGORY = "category";
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tv_newgood)
    TextView tvNewgood;
    @BindView(R.id.tv_new_all)
    TextView tvNewAll;
    @BindView(R.id.iv_up_new)
    ImageView ivUpNew;
    @BindView(R.id.iv_down_new)
    ImageView ivDownNew;
    @BindView(R.id.tv_new_sort)
    TextView tvNewSort;
    @BindView(R.id.ry_new)
    RecyclerView ryNew;
    @BindView(R.id.tv_new_price)
    TextView tvNewPrice;
    @BindView(R.id.ll_new)
    LinearLayout llNew;
    @BindView(R.id.con_newgood)
    ConstraintLayout conNewgood;
    @BindView(R.id.ry_waterful)
    RecyclerView ryWaterful;
    //是否是新品
    private int isNew = 1;
    private int page = 1;
    private int size = 1000;
    private String order;
    private String sort;
    private int categoryId;
    private HashMap<String, String> map;
    private ArrayList<NewListBean.DataBeanX.DataBean> list;
    private NewGoodAdapter newGoodAdapter;
    private ArrayList<NewListBean.DataBeanX.FilterCategoryBean> waterList;
    private SortAdapter sortAdapter;
    //判断选中分类
    boolean isSelect = false;

    @Override
    protected int getLayout() {
        return R.layout.newgood_layout;
    }

    @SuppressLint("ResourceType")
    @Override
    protected INewGoods.NewPre createPrenter() {
        return new NewPre();

    }

    @SuppressLint("ResourceType")
    @Override
    protected void initView() {
        order = ASC;
        sort = DEFAULT;
        categoryId = 0;
        llNew.setTag(0);
        tvNewAll.setTextColor(Color.parseColor(NewGoodsActivity.this.getString(R.color.red)));

        //分类弹窗
        ryWaterful.setLayoutManager(new GridLayoutManager(NewGoodsActivity.this, 5));
        waterList = new ArrayList<>();
        sortAdapter = new SortAdapter(NewGoodsActivity.this, waterList);
        ryWaterful.setAdapter(sortAdapter);
        sortAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                NewListBean.DataBeanX.FilterCategoryBean filterCategoryBean = waterList.get(pos);
                int id = filterCategoryBean.getId();
                categoryId = id;

                presenter.getNewPre(getParam());
                isSelect = false;
                ryWaterful.setVisibility(View.GONE);
            }
        });
    }

    //点击价格换图标
    @SuppressLint("ResourceType")
    @OnClick({R.id.tv_new_price, R.id.tv_new_all, R.id.tv_new_sort})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_new_price:
                int tag = (int) llNew.getTag();
                if (tag == 0) {
                    restPriceNomal();
                    restPriceUp();
                    llNew.setTag(1);
                    order = ASC;
                } else if (tag == 1) {
                    restPriceNomal();
                    restPriceDown();
                    llNew.setTag(0);
                    order = DESC;
                }
                sort = PRICE;
                presenter.getNewPre(getParam());

                //如果选中价格
                if (isSelect) {
                    isSelect = false;
                    ryWaterful.setVisibility(View.GONE);
                }
                break;
            case R.id.tv_new_all:
                restPriceNomal();
                tvNewAll.setTextColor(Color.parseColor(NewGoodsActivity.this.getString(R.color.red)));
                sort = DEFAULT;
                categoryId = 0;
                presenter.getNewPre(getParam());

                //如果选中全部
                if (isSelect) {
                    isSelect = false;
                    ryWaterful.setVisibility(View.GONE);
                }
                break;
            case R.id.tv_new_sort:
                restPriceNomal();
                tvNewSort.setTextColor(Color.parseColor(NewGoodsActivity.this.getString(R.color.red)));
                sort = CATEGORY;
                presenter.getNewPre(getParam());

                if (isSelect) {
                    isSelect = false;
                } else {
                    isSelect = true;
                }

                if (isSelect) {
                    ryWaterful.setVisibility(View.VISIBLE);
                } else {
                    ryWaterful.setVisibility(View.GONE);
                }

                break;
        }
    }

    /**
     * 组装当前的接口参数
     *
     * @return
     */
    private HashMap<String, String> getParam() {
        map = new HashMap<>();
        map.put("isNew", String.valueOf(isNew));
        map.put("page", String.valueOf(page));
        map.put("size", String.valueOf(size));
        map.put("order", order);
        map.put("sort", sort);
        map.put("categoryId", String.valueOf(categoryId));

        return map;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void initData() {
        presenter.getNewPre(map);
        presenter.getNewTopP();


        restPriceNomal();
        tvNewAll.setTextColor(Color.parseColor(NewGoodsActivity.this.getString(R.color.red)));
        sort = DEFAULT;
        presenter.getNewPre(getParam());
    }

    @Override
    public void getNewReturn(NewListBean newListBean) {
        if (newListBean != null) {
            //热门商品详细
            Initgoods(newListBean.getData().getData());
            //分类接受数据
            InitSort(newListBean.getData().getFilterCategory());
        }

    }

    //分类接受数据
    private void InitSort(List<NewListBean.DataBeanX.FilterCategoryBean> filterCategory) {
        waterList.clear();
        waterList.addAll(filterCategory);
        sortAdapter.notifyDataSetChanged();
    }

    @Override
    public void getNewTop(NewTopBean newTopBean) {
        if (newTopBean != null) {
            InitgoodTop(newTopBean.getData().getBannerInfo());
        }

    }

    //热门商品详细
    private void Initgoods(List<NewListBean.DataBeanX.DataBean> data) {
        ryNew.setLayoutManager(new GridLayoutManager(NewGoodsActivity.this, 2));
        list = new ArrayList<>();
        newGoodAdapter = new NewGoodAdapter(NewGoodsActivity.this, list);
        ryNew.setAdapter(newGoodAdapter);
        list.addAll(data);
        Log.i("TAG", "Initgoods: " + list.toString());
        newGoodAdapter.notifyDataSetChanged();


    }

    private void InitgoodTop(NewTopBean.DataBean.BannerInfoBean bannerInfo) {
        Glide.with(NewGoodsActivity.this).load(bannerInfo.getImg_url()).into(ivImg);
        tvNewgood.setText(bannerInfo.getName());
    }


    @Override
    public void tips(String tip) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    //重置图标升序
    private void restPriceUp() {
        ivUpNew.setImageResource(R.drawable.ic_arrow_up_select);
        ivDownNew.setImageResource(R.drawable.ic_arrow_down_normal);
        tvNewPrice.setTextColor(Color.parseColor(getString(R.color.red)));

    }

    //重置图标降序
    @SuppressLint("ResourceType")
    private void restPriceDown() {
        ivUpNew.setImageResource(R.drawable.ic_arrow_up_normal);
        ivDownNew.setImageResource(R.drawable.ic_arrow_down_select);
        tvNewPrice.setTextColor(Color.parseColor(getString(R.color.red)));
    }

    //重置图标恢复默认
    //重置条件选择的所有状态
    @SuppressLint("ResourceType")
    private void restPriceNomal() {
        ivUpNew.setImageResource(R.drawable.ic_arrow_up_normal);
        ivDownNew.setImageResource(R.drawable.ic_arrow_down_normal);

        tvNewPrice.setTextColor(Color.parseColor(getString(R.color.black)));
        tvNewAll.setTextColor(Color.parseColor(getString(R.color.black)));
        tvNewSort.setTextColor(Color.parseColor(getString(R.color.black)));
        llNew.setTag(0);
    }


}
