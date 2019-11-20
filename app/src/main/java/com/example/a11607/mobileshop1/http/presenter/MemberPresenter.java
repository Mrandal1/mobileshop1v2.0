package com.example.a11607.mobileshop1.http.presenter;

import android.util.Log;

import com.example.a11607.mobileshop1.http.HttpMethods;
import com.example.a11607.mobileshop1.http.entity.MemberEntity;


import rx.Subscriber;
import rx.Observable;

public class MemberPresenter extends HttpMethods{
    public  static  void register(Subscriber<MemberEntity> subscriber,String username,String email,String password){
        Observable observable=memberService.register(username,password,email)
                .map(new  HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }
    public  static  void login2(Subscriber<MemberEntity> subscriber,String username,String password){
        Observable observable=memberService.login2(username,password)
                .map(new  HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }
    public  static  void changePassword(Subscriber<MemberEntity> subscriber,String memberId,String old_pwd,String new_pwd){
        Observable observable=memberService.changePassword(memberId,old_pwd,new_pwd);
        toSubscribe(observable,subscriber);
    }

    }

