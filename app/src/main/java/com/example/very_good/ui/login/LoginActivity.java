package com.example.very_good.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.very_good.R;
import com.example.very_good.RegisterActivity;
import com.example.very_good.base.BaseActivity;
import com.example.very_good.bean.login.LoginBean;
import com.example.very_good.interfaces.login.ILogin;
import com.example.very_good.presenter.home.login.LoginPre;
import com.example.very_good.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<ILogin.Presenter> implements ILogin.View {
    @BindView(R.id.input_username)
    EditText inputUsername;
    @BindView(R.id.input_pw)
    EditText inputPw;
    @BindView(R.id.img_pw)
    ImageView imgPw;
    @BindView(R.id.layout_pw)
    FrameLayout layoutPw;
    @BindView(R.id.btn_login)
    Button btnLogin;
    String register_token;
    String register_username;
    @BindView(R.id.me_login_regist)
    TextView meLoginRegist;
    @BindView(R.id.me_login_forget_psd)
    TextView meLoginForgetPsd;
    private String token;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected ILogin.Presenter createPrenter() {
        return new LoginPre();
    }

    @Override
    protected void initView() {

        imgPw.setTag(1);
        Intent intent = getIntent();
        register_token = intent.getStringExtra("register_token");
        register_username = intent.getStringExtra("register_username");


        meLoginRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void loginReturn(LoginBean result) {
        token = result.getData().getToken();
        if (!TextUtils.isEmpty(result.getData().getToken())) {
            SpUtils.getInstance().setValue("token", result.getData().getToken());
            SpUtils.getInstance().setValue("uid", result.getData().getUserInfo().getUid());

            String name = inputUsername.getText().toString();
            Intent intent = getIntent();
            intent.putExtra("name", name);
            setResult(100, intent);

            finish();//关闭当前页面返回之前页面+
        }
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

    @OnClick({R.id.btn_login, R.id.img_pw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.img_pw:
                int tag = (int) imgPw.getTag();
                if (tag == 1) {
                    imgPw.setImageResource(R.mipmap.ic_pw_open);
                    imgPw.setTag(2);
                    inputPw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    imgPw.setImageResource(R.mipmap.ic_pw_close);
                    imgPw.setTag(1);
                    inputPw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

                break;
        }
    }

    private void login() {
        String username = inputUsername.getText().toString();
        String pw = inputPw.getText().toString();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pw)) {
            presenter.login(username, pw);
        } else {
            Toast.makeText(this, "请输入正确的用户名和密码", Toast.LENGTH_SHORT).show();
        }

    }
}
