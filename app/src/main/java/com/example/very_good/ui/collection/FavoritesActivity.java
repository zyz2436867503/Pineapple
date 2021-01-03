package com.example.very_good.ui.collection;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.very_good.R;
import com.example.very_good.base.BaseActivity;
import com.example.very_good.interfaces.IBasePresenter;
import com.example.very_good.ui.adpter.collection.FavoritesAdapter;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;


public class FavoritesActivity extends BaseActivity {
    @BindView(R.id.ry_favor)
    SwipeMenuRecyclerView ryFavor;
    private List<Favorites> list;
    private RealmResults<Favorites> all;
    private FavoritesAdapter favoritesAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_favor;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {

        ryFavor.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        ryFavor.setSwipeMenuCreator(swipeMenuCreator);
        // 设置菜单Item点击监听
        ryFavor.setSwipeMenuItemClickListener(menuItemClickListener);
        favoritesAdapter = new FavoritesAdapter(this, list);
        ryFavor.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        ryFavor.setAdapter(favoritesAdapter);
        favoritesAdapter.notifyDataSetChanged();
    }

    //创建侧滑菜单
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            SwipeMenuItem swipeMenuItem = new SwipeMenuItem(FavoritesActivity.this)
                    .setImage(R.mipmap.delete)
                    .setWidth(144)//设置
                    .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);//高（MATCH_PARENT意为Item多高侧滑菜单多高 （推荐使用）;
            swipeRightMenu.addMenuItem(swipeMenuItem);
        }
    };


    //创建侧滑菜单的点击事件
    private SwipeMenuItemClickListener menuItemClickListener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {

            //删除数据库
            if (list.size() > 0) {
                //先查找到数据
                Realm realm = Realms.getRealm(FavoritesActivity.this);
                final RealmResults<Favorites> userList = Realms.getRealm(FavoritesActivity.this).where(Favorites.class).findAll();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        menuBridge.closeMenu();
                        int adapterPosition = menuBridge.getAdapterPosition();
                        userList.get(adapterPosition).deleteFromRealm();
                        initData();
                    }
                });
                favoritesAdapter.notifyDataSetChanged();
            }

        }
    };

    @Override
    protected void initData() {
        //查询保存到数据库的值
        all = Realms.getRealm(FavoritesActivity.this).where(Favorites.class).findAll();
        this.list.clear();
        this.list.addAll(all);
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
}
