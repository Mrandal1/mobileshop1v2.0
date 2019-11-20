package com.example.a11607.mobileshop1.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity  extends AppCompatActivity {
private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initView();
        initData();

    }

    protected void initView() {
    }

    protected void initData() {
    }

    public abstract int getContentViewId();

    public void toastshort(String msg) {
        Toast.makeText(this, "msg", Toast.LENGTH_SHORT).show();
    }
    public void toastlong(String msg) {
        Toast.makeText(this, "msg", Toast.LENGTH_LONG).show();
    }
}
