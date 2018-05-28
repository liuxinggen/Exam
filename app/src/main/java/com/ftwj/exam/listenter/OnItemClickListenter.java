package com.ftwj.exam.listenter;

import android.view.View;

/**
 * 类名：com.ftwj.exam.listenter
 * 时间：2018/5/25 13:39
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public interface OnItemClickListenter {

    /**
     * 单击事件
     * @param v
     * @param position  子布局的位置
     * @param layoutPosition   点击的位置
     * @param oid  选项id
     * @param tid  题目id
     */
    void onClick(View v,int position,int layoutPosition,int tid,int oid);
}
