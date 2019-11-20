package com.example.a11607.mobileshop1.activity;

import android.widget.TextView;

import com.example.a11607.mobileshop1.common.BaseActivity;
import com.example.a11607.mobileshop1.R;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangePwdActivity extends BaseActivity{
    @Override
    public int getContentViewId() {
        return R.layout.activity_change_pwd;
    }
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText("修改密码  ");
    }
    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }
}
