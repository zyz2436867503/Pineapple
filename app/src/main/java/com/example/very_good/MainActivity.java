package com.example.very_good;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.very_good.ui.home.HomeFragment;
import com.example.very_good.ui.mine.MineFragment;
import com.example.very_good.ui.shop.ShopFragment;
import com.example.very_good.ui.sort.SortFragment;
import com.example.very_good.ui.topic.TopicFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.con_main)
    ConstraintLayout conMain;


    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;


    List<Fragment> fragments;
    MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomNavigationView = findViewById(R.id.nav_view);
        viewPager = findViewById(R.id.viewPager);

        initFragment();
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(myFragmentPagerAdapter);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        item.setIcon(R.mipmap.ic_menu_choice_pressed);
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_topic:
                        item.setIcon(R.mipmap.ic_menu_topic_pressed);
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_sort:
                        item.setIcon(R.mipmap.ic_menu_sort_pressed);
                        viewPager.setCurrentItem(2);
                        return true;
                    case R.id.navigation_shop:
                        item.setIcon(R.mipmap.ic_menu_shoping_pressed);
                        viewPager.setCurrentItem(3);
                        return true;
                    case R.id.navigation_me:
                        item.setIcon(R.mipmap.ic_menu_me_pressed);
                        viewPager.setCurrentItem(4);
                        return true;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TopicFragment());
        fragments.add(new SortFragment());
        fragments.add(new ShopFragment());
        fragments.add(new MineFragment());
    }


    class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragments;

        public MyFragmentPagerAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }


}