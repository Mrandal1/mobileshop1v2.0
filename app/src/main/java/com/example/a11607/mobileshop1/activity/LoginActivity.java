package com.example.a11607.mobileshop1.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a11607.mobileshop1.R;
import com.example.a11607.mobileshop1.common.BaseActivity;
import com.example.a11607.mobileshop1.common.Constans;
import com.example.a11607.mobileshop1.http.ProgressDialogSubscriber;
import com.example.a11607.mobileshop1.http.entity.MemberEntity;
import com.example.a11607.mobileshop1.http.presenter.MemberPresenter;
import com.example.a11607.mobileshop1.utils.SystemConfig;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

public class LoginActivity extends BaseActivity{
   @BindView(R.id.et_username)
   EditText etusername;
   @BindView(R.id.et_pwd)
   EditText etpwd;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }
    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }
    @OnClick(R.id.bt_login)
    void login(){
        String username=etusername.getText().toString().trim();
        String pwd=etpwd.getText().toString().trim();
        if (TextUtils.isEmpty(username)){

            Toast.makeText(LoginActivity.this,"请输入用户名",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pwd)){

            Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
            return;
        }
        MemberPresenter.login2(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                SystemConfig.setLogin(true);
                Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                SystemConfig.setLoginUserName(memberEntity.uname);
                SystemConfig.setLoginUserEmail(memberEntity.email);
                SystemConfig.setLoginUserHead(memberEntity.image);
                sendLoginBroadcast();
                setResult(RESULT_OK);
                finish();
            }
        },username,pwd);
    }
private void sendLoginBroadcast(){
    Intent intent=new Intent();
    intent.setAction(Constans.ACTION_LOGIN);
    intent.putExtra("my_data","这是数据");
    sendBroadcast(intent);
}
    }


