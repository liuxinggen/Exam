package com.ftwj.exam.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;

/**
 * 类名：com.ftwj.exam.utils
 * 时间：2018/5/25 18:08
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class DialogHelper {

    /***
     * 获取一个dialog对象，进行相关操作
     *
     * @param context
     * @return
     */
    public static AlertDialog.Builder getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder;
    }

    /**
     * 可设置内容、确定监听对话框
     *
     * @param context
     * @param message
     * @param onClickListener
     * @return
     */
    public static AlertDialog.Builder getConfirmDialog(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = getDialog(context);
        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton("确定", onClickListener);
        return builder;
    }

    /**
     * 可设置自定义布局、两个按钮监听对话框
     *
     * @param context
     * @param view
     * @param onOkClickListener
     * @param onCancleClickListener
     * @return
     */
    public static AlertDialog.Builder getConfirmDialoglayout(Context context,
                                                             String title,
                                                             View view,
                                                             DialogInterface.OnClickListener onOkClickListener
                                                             ) {
        AlertDialog.Builder builder = getDialog(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setView(view);
        builder.setPositiveButton("确定", onOkClickListener);
        return builder;
    }


}
