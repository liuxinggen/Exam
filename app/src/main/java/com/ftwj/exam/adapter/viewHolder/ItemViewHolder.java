package com.ftwj.exam.adapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ftwj.exam.R;

/**
 * 类名：com.ftwj.exam.Adapter.ViewHolder
 * 时间：2018/5/25 11:27
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public RadioButton rbOption;
    public TextView tvOption;
    public LinearLayout item;


    public ItemViewHolder(View itemView) {
        super(itemView);
        findViews(itemView);
    }



    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2018-05-25 11:34:29 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews(View itemView) {
        rbOption = (RadioButton)itemView.findViewById( R.id.rb_option );
        tvOption = (TextView)itemView.findViewById( R.id.tv_option );
        item=itemView.findViewById(R.id.item);
    }


}
