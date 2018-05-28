package com.ftwj.exam;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ftwj.exam.adapter.MainAdapter;
import com.ftwj.exam.bean.ContentBean;
import com.ftwj.exam.bean.ResultBean;
import com.ftwj.exam.bean.SubjectBean;
import com.ftwj.exam.listenter.OnSubmitClickListenter;
import com.ftwj.exam.net.HttpCallback;
import com.ftwj.exam.net.HttpClient;
import com.ftwj.exam.utils.DialogHelper;
import com.ftwj.exam.utils.JsonUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类名： ExamActivity
 * 时间：2018/5/25 11:05
 * 描述：答题界面
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */
public class ExamActivity extends AppCompatActivity {

    public static final String TAG = "ExamActivity";
    private RecyclerView rlMain;

    private MainAdapter adapter;

    /**
     * 题目和选项列表
     */
    private List<ContentBean.DataBean> listContents;

    private Activity mActivity;

    private AlertDialog.Builder mBuilder;
    /**
     * 进度条对话框
     */
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        mActivity = this;
        initView();
    }

    private void initView() {
        mProgressDialog=new ProgressDialog(this);
        mProgressDialog.setTitle("提示");
        mProgressDialog.setMessage("正在加载中，请稍等。。。。");
        //设置可否用back键关闭
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        rlMain = findViewById(R.id.rl_main);
        int subid = getIntent().getIntExtra("subId", 0);
        //查询内容
        HttpClient.getInstance().getContent(subid, new HttpCallback<ContentBean>() {
            @Override
            public void onSuccess(ContentBean response, int id) {
                mProgressDialog.dismiss();
                if (response.getCode() == 200) {
                    setContent(response);
                } else {
                    mBuilder = DialogHelper
                            .getConfirmDialog(ExamActivity.this,
                                    "该科目暂无题目",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            onBackPressed();
                                        }
                                    });
                    mBuilder.show();
                }
            }

            @Override
            public void onError(Exception e, int id) {
                //失败
                Log.i(TAG, "onError: 失败");
                mProgressDialog.dismiss();
            }
        });


    }

    /**
     * 设置内容
     *
     * @param response
     */

    private void setContent(ContentBean response) {
        listContents = response.getData();
        listContents.add(new ContentBean.DataBean());
        adapter = new MainAdapter(getApplicationContext(), listContents);
        rlMain.setLayoutManager(new LinearLayoutManager(ExamActivity.this));
        rlMain.setAdapter(adapter);

        adapter.setOnSubmitClickListenter(new OnSubmitClickListenter() {
            @Override
            public void onClick(View v, Object objArr) {
                String str = JsonUtil.parseListForMapsToJsonArrayStr((List<Map<String, Object>>) objArr);
                HttpClient.getInstance().submit(str, new HttpCallback<ResultBean>() {
                    @Override
                    public void onSuccess(ResultBean response, int id) {
                        View view = LayoutInflater.from(mActivity)
                                .inflate(R.layout.layout_result_show, null);
                        findViews(view);
                        tvScore.setText("总得分：" + response.getScore());
                        tvTyes.setText("已答数：" + response.getTYes());
                        tvTno.setText("未答数：" + response.getTNo());
                        tvOtrue.setText("答对数：" + response.getOTrue());
                        tvOfalse.setText("答错数：" + response.getOFalse());
                        tvTotalTitle.setText("总题数：" + response.getTotalTitle());
                        DialogHelper.getConfirmDialoglayout(mActivity,
                                "答题结果", view,
                                null)
                                .show();

                    }

                    @Override
                    public void onError(Exception e, int id) {

                    }
                });


            }
        });
    }


    private TextView tvScore;
    private TextView tvTyes;
    private TextView tvTno;
    private TextView tvOtrue;
    private TextView tvOfalse;
    private TextView tvTotalTitle;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2018-05-25 18:16:54 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews(View view) {
        tvScore = (TextView) view.findViewById(R.id.tv_score);
        tvTyes = (TextView) view.findViewById(R.id.tv_tyes);
        tvTno = (TextView) view.findViewById(R.id.tv_tno);
        tvOtrue = (TextView) view.findViewById(R.id.tv_otrue);
        tvOfalse = (TextView) view.findViewById(R.id.tv_ofalse);
        tvTotalTitle = (TextView) view.findViewById(R.id.tv_totalTitle);
    }


}
