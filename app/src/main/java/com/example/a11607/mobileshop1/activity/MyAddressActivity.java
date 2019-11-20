package com.example.a11607.mobileshop1.activity;

import android.widget.TextView;

import com.example.a11607.mobileshop1.R;
import com.example.a11607.mobileshop1.common.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MyAddressActivity extends BaseActivity {
    @Override
    public int getContentViewId() {
        return R.layout.activity_my_address;
    }
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText("我的地址");
    }
    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }
}
