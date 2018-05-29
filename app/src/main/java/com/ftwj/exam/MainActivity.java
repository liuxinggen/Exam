package com.ftwj.exam;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.ftwj.exam.adapter.SpinnerAdapter;
import com.ftwj.exam.bean.SubjectBean;
import com.ftwj.exam.net.HttpCallback;
import com.ftwj.exam.net.HttpClient;
import com.ftwj.exam.utils.DialogHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： MainActivity
 * 时间：2018/5/25 11:05
 * 描述：开始答题
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */
public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private Spinner spinner;
    private Button btnStart;

    private List<String> subNames;
    private List<Integer> subIds;

    private int subid;

    private SpinnerAdapter adapter;

    /**
     * 进度条对话框
     */
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initView();
        initEvent();


    }

    private void initEvent() {
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //获取选中的id值
                subid = subIds.get(position);
                Log.i(TAG, "onItemSelected: " + subid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始答题
                Intent intent = new Intent(MainActivity.this, ExamActivity.class);
                intent.putExtra("subId", subid);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        mProgressDialog=new ProgressDialog(this);
        mProgressDialog.setTitle("提示");
        mProgressDialog.setMessage("正在加载中，请稍等。。。。");
        //设置可否用back键关闭
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        subNames = new ArrayList<>();
        subIds = new ArrayList<>();
        HttpClient.getInstance().getSubjects(new HttpCallback<SubjectBean>() {
            @Override
            public void onSuccess(SubjectBean response, int id) {
                mProgressDialog.dismiss();

                if (response.getCode() == 200) {
                    List<SubjectBean.DataBean> data = response.getData();
                    for (int i = 0; i < response.getData().size(); i++) {
                        subIds.add(response.getData().get(i).getId());
                    }
                    adapter = new SpinnerAdapter(MainActivity.this,data);
                    spinner.setAdapter(adapter);
                } else {
                    Log.i(TAG, "onError: 失败");
                }
            }

            @Override
            public void onError(Exception e, int id) {
                mProgressDialog.dismiss();
                Log.i(TAG, "onError: 失败");
            }
        });


    }


    private void findViews() {
        spinner = (Spinner) findViewById(R.id.spinner);
        btnStart = (Button) findViewById(R.id.btn_start);

    }


}
