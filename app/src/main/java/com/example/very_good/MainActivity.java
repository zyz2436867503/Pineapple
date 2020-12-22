package com.example.very_good;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.very_good.ui.home.HomeFragment;
import com.example.very_good.ui.mine.MineFragment;
import com.example.very_good.ui.shop.ShopFragment;
import com.example.very_good.ui.sort.SortFragment;
import com.example.very_good.ui.topic.TopicFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    //private BottomNavigationView nav_view;
    private HomeFragment homeFragment;
    private MineFragment mineFragment;
    private ShopFragment shopFragment;
    private SortFragment sortFragment;
    private TopicFragment topicFragment;
    private LinearLayout mContent;
    private RadioButton mHome;
    private RadioButton mTopic;
    private RadioButton mSort;
    private RadioButton mShop;
    private RadioButton mMine;
    private RadioGroup mRadiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        mineFragment = new MineFragment();
        shopFragment = new ShopFragment();
        sortFragment = new SortFragment();
        topicFragment = new TopicFragment();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content, homeFragment)
                .add(R.id.content, topicFragment)
                .add(R.id.content, sortFragment)
                .add(R.id.content, shopFragment)
                .add(R.id.content, mineFragment)
                .hide(topicFragment)
                .hide(sortFragment)
                .hide(shopFragment)
                .hide(mineFragment)
                .commit();
    }

    private void initView() {
        mContent = findViewById(R.id.content);

        mRadiogroup = findViewById(R.id.radiogroup);

        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                switch (checkedId){
                    case R.id.home:
                        fragmentTransaction.hide(topicFragment)
                                .hide(sortFragment)
                                .hide(shopFragment)
                                .hide(mineFragment)
                                .show(homeFragment).commit();
                        break;
                    case R.id.topic:
                        fragmentTransaction.hide(homeFragment)
                                .hide(sortFragment)
                                .hide(shopFragment)
                                .hide(mineFragment)
                                .show(topicFragment).commit();
                        break;
                        case R.id.sort:
                            fragmentTransaction.hide(homeFragment)
                                    .hide(topicFragment)
                                    .hide(shopFragment)
                                    .hide(mineFragment)
                                    .show(sortFragment).commit();
                        break;
                    case R.id.shop:
                        fragmentTransaction.hide(homeFragment)
                                .hide(sortFragment)
                                .hide(topicFragment)
                                .hide(mineFragment)
                                .show(shopFragment).commit();
                        break;
                    case R.id.mine:
                        fragmentTransaction.hide(topicFragment)
                                .hide(sortFragment)
                                .hide(shopFragment)
                                .hide(homeFragment)
                                .show(mineFragment).commit();
                        break;


                }
            }
        });

        /*nav_view = (BottomNavigationView) findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_topic, R.id.navigation_sort,R.id.navigation_shop,R.id.navigation_me)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(nav_view, navController);
        *//*nav_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        item.setIcon(R.mipmap.ic_menu_choice_pressed);
                        break;
                    case R.id.navigation_topic:
                        item.setIcon(R.mipmap.ic_menu_topic_pressed);
                        break;
                    case R.id.navigation_sort:
                        item.setIcon(R.mipmap.ic_menu_sort_pressed);
                        break;
                    case R.id.navigation_shop:
                        item.setIcon(R.mipmap.ic_menu_shoping_pressed);
                        break;
                    case R.id.navigation_me:
                        item.setIcon(R.mipmap.ic_menu_me_pressed);
                        break;
                }
                return true;
            }
        });*/

    }
}