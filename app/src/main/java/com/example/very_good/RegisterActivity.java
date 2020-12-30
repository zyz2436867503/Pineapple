package com.example.very_good;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.very_good.base.BaseActivity;
import com.example.very_good.bean.register.RegisterBean;
import com.example.very_good.interfaces.register.IRegist;
import com.example.very_good.presenter.home.register.RegistPresenter;
import com.example.very_good.utils.SpUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity<IRegist.Persenter> implements IRegist.View {
    @BindView(R.id.me_regist_input_username)
    EditText meRegistInputUsername;
    @BindView(R.id.me_regist_input_pw)
    EditText meRegistInputPw;
    @BindView(R.id.me_regist_input_pw2)
    EditText meRegistInputPw2;
    @BindView(R.id.me_regist_input_verification)
    EditText meRegistInputVerification;
    @BindView(R.id.me_regist_btn_verification)
    ImageView meRegistBtnVerification;
    @BindView(R.id.me_regist_btn_regist)
    Button meRegistBtnRegist;
    private String pwd;
    private String name;
    private String pwd2;
    private String token;

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected IRegist.Persenter createPrenter() {
        return new RegistPresenter();
    }

    @Override
    protected void initView() {
        meRegistBtnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = meRegistInputUsername.getText().toString();
                pwd = meRegistInputPw.getText().toString();
                pwd2 = meRegistInputPw2.getText().toString();

                if (!name.isEmpty() && !pwd.isEmpty() && !pwd2.isEmpty()) {
                    if (pwd.equals(pwd2)) {
                        if (SpUtils.getInstance().getString(name).isEmpty()) {
                            cch(name,pwd);

                        }
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void cch(String name, String pwd) {
        presenter.getMeRegist(name, pwd);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void getMeRegistReturn(RegisterBean result) {
        if (result.getData()!=null){
            token = result.getData().getToken().toString();
            if (!token.isEmpty()) {
                SpUtils.getInstance().setValue(name, token);
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "data空了", Toast.LENGTH_SHORT).show();
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
}
