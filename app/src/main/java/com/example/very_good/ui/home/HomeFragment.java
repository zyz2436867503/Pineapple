package com.example.very_good.ui.home;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.very_good.R;
import com.example.very_good.app.MyApp;
import com.example.very_good.base.BaseAdapter;
import com.example.very_good.base.BaseFragment;
import com.example.very_good.bean.CategoryBean;
import com.example.very_good.bean.HomeBean;
import com.example.very_good.interfaces.home.Ihome;
import com.example.very_good.presenter.home.HomePresenter;
import com.example.very_good.ui.adpter.BrandAdapter;
import com.example.very_good.ui.adpter.CateAdaper;
import com.example.very_good.ui.adpter.HotAdapter;
import com.example.very_good.ui.adpter.NewAdapter;
import com.example.very_good.ui.adpter.TopAdapter;
import com.example.very_good.ui.topic.Topic_CommentActivity;
import com.example.very_good.utils.TxtUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment<Ihome.HomePresenter> implements Ihome.HomeView {

    @BindView(R.id.et_home)
    EditText etHome;
    @BindView(R.id.banner_home)
    Banner bannerHome;
    @BindView(R.id.ry_home)
    RecyclerView ryHome;
    @BindView(R.id.ry_zy_zs)
    RecyclerView ryZyZs;
    @BindView(R.id.ry_ren)
    RecyclerView ryRen;
    @BindView(R.id.ry_top)
    RecyclerView ryTop;
    @BindView(R.id.ry_live_cate)
    RecyclerView ryLiveCate;
    @BindView(R.id.layout_tab)
    LinearLayout layoutTab;
    @BindView(R.id.brand)
    TextView brand;
    @BindView(R.id.hotgood)
    TextView hotgood;
    private ArrayList<HomeBean.DataBean.BrandListBean> bList;
    private BrandAdapter brandAdapter;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> newGoods;
    private NewAdapter newAdapter;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> hotgoods;
    private HotAdapter hotAdapter;
    private ArrayList<HomeBean.DataBean.TopicListBean> topList;
    private TopAdapter topAdapter;
    private ArrayList<HomeBean.DataBean.CategoryListBean> cateList;
    private CateAdaper cateAdaper;

    @Override
    protected int getLayout() {
        return R.layout.homefragment_item;
    }

    @Override
    protected Ihome.HomePresenter createPrenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter.getHomeP();
    }

    @Override
    public void getHomeReturn(HomeBean homeBean) {
        if (homeBean != null) {
            Initbanner(homeBean.getData().getBanner());
            InitChannel(homeBean.getData().getChannel());
            InitbrandList(homeBean.getData().getBrandList());
            InitNewGoods(homeBean.getData().getNewGoodsList());
            InitHotGoods(homeBean.getData().getHotGoodsList());
            InitTopic(homeBean.getData().getTopicList());
            InitCate(homeBean.getData().getCategoryList());
        } else {
            Log.i("TAG", "getHomeReturn: " + "空了");
        }
    }

    private void InitCate(List<HomeBean.DataBean.CategoryListBean> categoryList) {
        if (categoryList != null && categoryList.size() > 0) {
            ryLiveCate.setLayoutManager(new LinearLayoutManager(getActivity()));
            cateList = new ArrayList<>();
            cateAdaper = new CateAdaper(getActivity(), cateList);
            cateList.addAll(categoryList);
            ryLiveCate.setAdapter(cateAdaper);
            cateAdaper.notifyDataSetChanged();

            cateAdaper.addListClick(new BaseAdapter.IListClick() {
                @Override
                public void itemClick(int pos) {
                    Intent intent = new Intent(getActivity(), LiveItemActivity.class);
                    int id = categoryList.get(pos).getGoodsList().get(pos).getId();
                    Log.i("TAG", "itemClick: " + id);
                    intent.putExtra("id", categoryList.get(pos).getGoodsList().get(pos).getId());
                    startActivity(intent);
                }
            });
        } else {
            Log.i("TAG", "InitCate: " + "listnull");
        }

    }

    private void InitTopic(List<HomeBean.DataBean.TopicListBean> topicList) {
        ryTop.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        topList = new ArrayList<>();
        topAdapter = new TopAdapter(getActivity(), topList);
        topList.addAll(topicList);
        ryTop.setAdapter(topAdapter);
        topAdapter.notifyDataSetChanged();

        topAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(mContext, Topic_CommentActivity.class);
                int id = topicList.get(pos).getId();

                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }

    private void InitHotGoods(List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList) {
        ryRen.setLayoutManager(new LinearLayoutManager(getActivity()));
        hotgoods = new ArrayList<>();
        hotAdapter = new HotAdapter(getActivity(), hotgoods);
        hotgoods.addAll(hotGoodsList);
        ryRen.setAdapter(hotAdapter);
        hotAdapter.notifyDataSetChanged();
        ryRen.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        hotAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(mContext, LiveItemActivity.class);
                int id = hotGoodsList.get(pos).getId();
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }

    private void InitNewGoods(List<HomeBean.DataBean.NewGoodsListBean> newGoodsList) {
        ryZyZs.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        newGoods = new ArrayList<>();
        newAdapter = new NewAdapter(getActivity(), newGoods);
        ryZyZs.setAdapter(newAdapter);
        newGoods.addAll(newGoodsList);
        newAdapter.notifyDataSetChanged();
        newAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(mContext, LiveItemActivity.class);
                int id = newGoodsList.get(pos).getId();
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }

    /**
     * 品牌制造
     *
     * @param brandList
     */
    private void InitbrandList(List<HomeBean.DataBean.BrandListBean> brandList) {
        ryHome.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        bList = new ArrayList<>();
        brandAdapter = new BrandAdapter(getActivity(), bList);
        ryHome.setAdapter(brandAdapter);
        bList.addAll(brandList);
        brandAdapter.notifyDataSetChanged();
        brandAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int id = brandList.get(pos).getId();
                Intent intent = new Intent(mContext, BrandItemActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }

    /**
     * 居家导航栏
     *
     * @param
     */
    private void InitChannel(List<HomeBean.DataBean.ChannelBean> channell) {
        layoutTab.removeAllViews();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        for (HomeBean.DataBean.ChannelBean item : channell) {
            View channel = LayoutInflater.from(getContext()).inflate(R.layout.layout_channel_item, layoutTab, false);
            ImageView img = channel.findViewById(R.id.img_channel);
            TextView txtChannel = channel.findViewById(R.id.txt_channel);

            Glide.with(getActivity()).load(item.getIcon_url()).into(img);
            TxtUtils.setTextView(txtChannel, item.getName());
            txtChannel.setGravity(Gravity.CENTER);
            channel.setLayoutParams(params);
            layoutTab.addView(channel);

            channel.setTag(item);
            channel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    channel.setTag(item);
                    String url = item.getUrl();
                    Intent intent = new Intent(getActivity(), ChannelActivity.class);
                    intent.putExtra("name", item.getName());
                    intent.putExtra("murl", url);
                    startActivity(intent);
                }
            });

        }
    }

    /**
     * banner
     *
     * @param banner
     */
    private void Initbanner(List<HomeBean.DataBean.BannerBean> banner) {
        Log.i("TAG", banner + "  ");
        if (banner != null && banner.size() > 0) {
            bannerHome.setImages(banner).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    HomeBean.DataBean.BannerBean data = (HomeBean.DataBean.BannerBean) path;
                    String image_url = data.getImage_url();
                    Glide.with(context).load(image_url).into(imageView);
                }
            }).start();
        }
    }

    @Override
    public void tips(String tip) {

    }

    @OnClick({R.id.brand, R.id.hotgood})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.brand:
                //品牌制造商列表
                startActivity(new Intent(new Intent(getActivity(), BrandActivity.class)));
                break;
            case R.id.hotgood:
                startActivity(new Intent(getActivity(), NewGoodsActivity.class));
                break;
        }
    }
}
