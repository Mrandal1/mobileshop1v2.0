package com.example.a11607.mobileshop1.common;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;

import com.example.a11607.mobileshop1.R;
import com.example.a11607.mobileshop1.Receiver.JpushReceiver;
import com.example.a11607.mobileshop1.http.HttpMethods;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import android.os.Handler;
import java.util.logging.LogRecord;

import cn.jpush.android.api.JPushInterface;

public class MobileShopApp extends Application {
    public static Handler handler=new Handler() ;
    private static Context sCountext;
    @Override
    public void onCreate(){
        super.onCreate();
        sCountext=getApplicationContext();
        initImageLoader();
        HttpMethods.getsInstance();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
    private void initImageLoader(){
        DisplayImageOptions default_options=new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.image_loading)
                .showImageForEmptyUri(R.drawable.image_empty)
                .showImageOnFail(R.drawable.image_error)
                .resetViewBeforeLoading(false)
                .delayBeforeLoading(1000)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(false)
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .displayer(new SimpleBitmapDisplayer())
                .handler(new Handler())
                .build();

        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCacheExtraOptions(480,800)
                .memoryCacheSize(2*1024*1024)
                .memoryCacheSizePercentage(13)
                .diskCacheSize(50*1024*1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY-2)
                .denyCacheImageMultipleSizesInMemory()
                .imageDownloader(new BaseImageDownloader(getApplicationContext()))
                .defaultDisplayImageOptions(default_options)
                .writeDebugLogs()
                .build();
        ImageLoader.getInstance().init(config);
    }

    public static Context getsCountext(){
        return sCountext;
    }
}
