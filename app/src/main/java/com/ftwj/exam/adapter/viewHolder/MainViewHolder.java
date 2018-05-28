package com.ftwj.exam.adapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ftwj.exam.R;

/**
 * 类名：com.ftwj.exam.Adapter.ViewHolder
 * 时间：2018/5/25 11:04
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class MainViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;
    public RecyclerView rlOptionContent;
    public MainViewHolder(View itemView) {
        super(itemView);
        findViews(itemView);
    }
    private void findViews(View itemView) {
        tvTitle = (TextView)itemView.findViewById( R.id.tv_title );
        rlOptionContent = (RecyclerView)itemView.findViewById( R.id.rl_option_content );
    }

}
