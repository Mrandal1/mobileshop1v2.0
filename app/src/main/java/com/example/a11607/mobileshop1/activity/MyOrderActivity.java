package com.example.a11607.mobileshop1.activity;

import android.widget.TextView;
import com.example.a11607.mobileshop1.R;
import com.example.a11607.mobileshop1.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MyOrderActivity extends BaseActivity {

@BindView(R.id.tv_title)
TextView tvTitle;
    @Override
    public int getContentViewId() {
        return R.layout.activity_my_order;
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText("我的订单");
    }
    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }
}
