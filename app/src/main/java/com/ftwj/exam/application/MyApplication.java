package com.ftwj.exam.application;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 类名：com.ftwj.exam.application
 * 时间：2018/5/25 10:28
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * zhy的okhttp网络框架
         * 注册OkHttp请求http请求
         * 自己主动取消的错误的 java.net.SocketException: Socket closed
         * 超时的错误是 java.net.SocketTimeoutException
         * 网络出错的错误是java.net.ConnectException: Failed to connect to xxxxx
         */
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("TAG"))
                //设置连接的超时时间
                .connectTimeout(150000L, TimeUnit.MILLISECONDS)
                //设置读的超时时间
                .readTimeout(150000L, TimeUnit.MILLISECONDS)
                //设置写的超时时间
                .writeTimeout(150000L, TimeUnit.SECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);

    }
}
