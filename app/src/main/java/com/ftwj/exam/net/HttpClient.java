package com.ftwj.exam.net;


import android.util.Log;

import com.ftwj.exam.bean.ContentBean;
import com.ftwj.exam.bean.ResultBean;
import com.ftwj.exam.bean.SubjectBean;
import com.ftwj.exam.utils.Constant;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

import static android.content.ContentValues.TAG;

/**
 * Created by Liu_xg on 2017/3/2.
 */

public class HttpClient {
    //单列模式
    private static HttpClient mAgriClient;

    private Gson mGson;

    public HttpClient() {
        mGson = new Gson();
    }

    public static HttpClient getInstance() {
        //synchronized锁死
        if (mAgriClient == null) {
            synchronized (HttpClient.class) {
                if (mAgriClient == null) {
                    mAgriClient = new HttpClient();
                }
            }
        }
        return mAgriClient;
    }


    /**
     * 获取题目和选项
     *
     * @param callback
     */
    public void getContent(int subid, final HttpCallback<ContentBean> callback) {


        //GET_CONTENT_URL
        OkHttpUtils.get()
                .url(Constant.GET_CONTENT_URL)
                .addParams("subid", String.valueOf(subid))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(e, id);
                        Log.i(TAG, "onResponse: " + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i(TAG, "onResponse11: " + response);
                        ContentBean dataBean = mGson.fromJson(response, ContentBean.class);
                        callback.onSuccess(dataBean, id);
                    }
                });

    }

    /**
     * 获取科目
     *
     * @param callback
     */
    public void getSubjects( final HttpCallback<SubjectBean> callback) {
        OkHttpUtils.get()
                .url(Constant.GET_SUBJECT_URL)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(e, id);
                        Log.i(TAG, "onResponse: " + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i(TAG, "onResponse11: " + response);
                        SubjectBean dataBean = mGson.fromJson(response, SubjectBean.class);
                        callback.onSuccess(dataBean, id);
                    }
                });

    }

    /**
     * 提交答案
     *
     * @param callback
     */
    public void submit( String result,final HttpCallback<ResultBean> callback) {
        OkHttpUtils.get()
                .url(Constant.GET_AUBMIT_URL)
                .addParams("params",result)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(e, id);
                        Log.i(TAG, "onResponse: " + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i(TAG, "onResponse11: " + response);
                        ResultBean dataBean = mGson.fromJson(response, ResultBean.class);
                        callback.onSuccess(dataBean, id);
                    }
                });

    }
}
