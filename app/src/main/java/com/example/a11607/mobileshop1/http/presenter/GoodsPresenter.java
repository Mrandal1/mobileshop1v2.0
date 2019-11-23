package com.example.a11607.mobileshop1.http.presenter;

import com.example.a11607.mobileshop1.http.HttpMethods;
import com.example.a11607.mobileshop1.http.entity.GoodsDetailEntity;
import com.example.a11607.mobileshop1.http.entity.GoodsEntity;

import java.util.List;
import rx.Observable;

import rx.Subscriber;

public class GoodsPresenter extends HttpMethods {
    public static  void listByKeywords(Subscriber<List<GoodsEntity>> subscriber,String keywords){
        Observable<List<GoodsEntity>> observable=goodsService.listByKeywords(keywords)
                .map(new HttpResultFunc<List<GoodsEntity>>());
        toSubscribe(observable,subscriber);
    }
    public static  void list(Subscriber<List<GoodsEntity>> subscriber,int catId){
        Observable<List<GoodsEntity>> observable=goodsService.list(catId)
                .map(new HttpResultFunc<List<GoodsEntity>>());
        toSubscribe(observable,subscriber);
    }
    public static  void goodsDetail(Subscriber <GoodsDetailEntity> subscriber, int goodsId){
        Observable <GoodsDetailEntity> observable=goodsService.goodsDetail(goodsId)
                .map(new HttpResultFunc <GoodsDetailEntity>());
        toSubscribe(observable,subscriber);
    }
}
