package com.example.very_good.ui.mine;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.very_good.R;
import com.example.very_good.base.BaseFragment;
import com.example.very_good.bean.HomeBean;
import com.example.very_good.interfaces.home.Ihome;
import com.example.very_good.ui.login.LoginActivity;
import com.example.very_good.utils.SpUtils;

import butterknife.BindView;

public class MineFragment extends BaseFragment<Ihome.HomePresenter> implements Ihome.HomeView {
    @BindView(R.id.me_head_login)
    TextView tv_Login;

    @Override
    protected int getLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    protected Ihome.HomePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {
        tv_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(SpUtils.getInstance().getString("token"))) {
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    startActivityForResult(intent, 100);

                    //ActivityManagerUtils.startActivity(getActivity(), LoginActivity.class);
                } else {
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 100) {
            String name = data.getStringExtra("name");//登录之后显示名字
            tv_Login.setText(name);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void getHomeReturn(HomeBean homeBean) {

    }

    @Override
    public void tips(String tip) {

    }
}
