package com.ftwj.exam.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ftwj.exam.R;
import com.ftwj.exam.adapter.viewHolder.ItemSubmitViewHolder;
import com.ftwj.exam.adapter.viewHolder.MainViewHolder;
import com.ftwj.exam.bean.ContentBean;
import com.ftwj.exam.listenter.OnItemClickListenter;
import com.ftwj.exam.listenter.OnSubmitClickListenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名：com.ftwj.exam.Adapter
 * 时间：2018/5/25 11:03
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * 题目和选项列表
     */
    private List<ContentBean.DataBean> listContents;

    private Context context;

    private ItemAdapter adapter;

    private OnSubmitClickListenter mOnSubmitClickListenter;

    public static final int CONTENT = 1;
    public static final int SUBMIT = 2;

    /**
     * 保存答案
     */
    private List<Map<String, Object>> results;
    private Map<String, Object> map;

    /**
     * 保存状态
     */
    private Map<String, Object> status;


    public MainAdapter(Context context, List<ContentBean.DataBean> listContents) {
        this.listContents = listContents;
        this.context = context;
        //指定存放答题记录的list为本次题目的数量，后面直接修改对应位置的记录即可
        results = new ArrayList<>();
        status = new HashMap<>();
        int i = 0;
        while (results.size() < (listContents.size() - 1)) {
            //默认值
            map = new HashMap<>();
            map.put("Tid", 0);
            map.put("Oid", 0);
            results.add(map);
            status.put("" + i, -1);
            i++;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SUBMIT) {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.layout_rl_item_submit, parent, false);
            return new ItemSubmitViewHolder(view);
        } else {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.layout_rl_main, parent, false);
            return new MainViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ItemSubmitViewHolder) {
            bindSubmit((ItemSubmitViewHolder) holder, position);
        } else {
            bindContent((MainViewHolder) holder, position);
        }
    }

    /**
     * 提交按钮
     *
     * @param holder
     * @param position
     */
    private void bindSubmit(ItemSubmitViewHolder holder, int position) {
        holder.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnSubmitClickListenter().onClick(v, results);
            }
        });
    }

    /**
     * 显示内容
     *
     * @param holder
     * @param index
     */
    private void bindContent(MainViewHolder holder, final int index) {
        holder.tvTitle.setText((index + 1) + "、  " + listContents.get(index).getTitle().getContent());
        adapter = new ItemAdapter(context,
                listContents.get(index).getOption(),
                status, index);
        holder.rlOptionContent.setLayoutManager(new LinearLayoutManager(context));
        holder.rlOptionContent.setAdapter(adapter);
        //禁用滑动事件
        holder.rlOptionContent.setNestedScrollingEnabled(false);
        adapter.setOnItemClickListenter(new OnItemClickListenter() {
            @Override
            public void onClick(View v, int position, int layoutPosition, int tid, int oid) {
                map = new HashMap<>();
                map.put("Tid", tid);
                map.put("Oid", oid);
                results.set(index, map);
                //记录当前在那个位置（父布局的index）
                status.put("parentPosition", index);
                //记录当前点击的是那一项
                status.put(String.valueOf(index), layoutPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listContents.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < (listContents.size() - 1)) {
            return CONTENT;
        } else {
            return SUBMIT;
        }

    }

    public OnSubmitClickListenter getOnSubmitClickListenter() {
        return mOnSubmitClickListenter;
    }

    public void setOnSubmitClickListenter(OnSubmitClickListenter onSubmitClickListenter) {
        mOnSubmitClickListenter = onSubmitClickListenter;
    }
}
