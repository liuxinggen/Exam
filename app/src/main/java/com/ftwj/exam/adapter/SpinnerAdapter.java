package com.ftwj.exam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ftwj.exam.R;
import com.ftwj.exam.bean.SubjectBean;

import java.util.List;

/**
 * 类名：com.ftwj.exam.adapter
 * 时间：2018/5/29 10:53
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class SpinnerAdapter extends BaseAdapter {

    private Context context;
    private List<SubjectBean.DataBean> data;

    public SpinnerAdapter(Context context, List<SubjectBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context)
                    .inflate(R.layout.layout_spinner_item,parent,false);
            viewHolder.tvItem=convertView.findViewById(R.id.tv_item);
            convertView.setTag(viewHolder);
        }

        viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.tvItem.setText(data.get(position).getName());
        return convertView;


    }

    class ViewHolder{
        public TextView tvItem;
    }
}
