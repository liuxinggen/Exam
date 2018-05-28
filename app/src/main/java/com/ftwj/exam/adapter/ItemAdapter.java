package com.ftwj.exam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.ftwj.exam.R;
import com.ftwj.exam.adapter.viewHolder.ItemViewHolder;
import com.ftwj.exam.bean.ContentBean;
import com.ftwj.exam.listenter.OnItemClickListenter;

import java.util.List;
import java.util.Map;

/**
 * 类名：com.ftwj.exam.Adapter
 * 时间：2018/5/25 11:26
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    private Context context;

    /**
     * 记录当前点击位置
     */
    private int layoutPosition=-1;

    private OnItemClickListenter mOnItemClickListenter;

    private Map<String, Object> status;

    /**
     * 父布局的position
     */
    private int parentPosition;

    /**
     * 选项列表
     */
    private List<ContentBean.DataBean.OptionBean> listOptions;

    public ItemAdapter(Context context,
                       List<ContentBean.DataBean.OptionBean> listOptions,
                       Map<String, Object> status,
                       int parentPosition) {
        this.context = context;
        this.listOptions = listOptions;
        this.status=status;
        this.parentPosition=parentPosition;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.layout_rl_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.rbOption.setText(listOptions.get(position).getIden());
        holder.tvOption.setText(listOptions.get(position).getContent());
        holder.item.setTag(position);
        //取出选中的位置
        layoutPosition=Integer.parseInt(status.get(""+parentPosition).toString());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutPosition=holder.getLayoutPosition();
                notifyDataSetChanged();
                getOnItemClickListenter()
                        .onClick(holder.item,
                                (int)holder.item.getTag(),
                                layoutPosition,
                                listOptions.get(position).getT_id(),
                                listOptions.get(position).getId());
            }
        });
        holder.rbOption.setTag(position);
        holder.rbOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutPosition=holder.getLayoutPosition();
                notifyDataSetChanged();
                getOnItemClickListenter()
                        .onClick(holder.rbOption,
                                (int)holder.rbOption.getTag(),
                                layoutPosition,
                                listOptions.get(position).getT_id(),
                                listOptions.get(position).getId());
            }
        });
        //更改状态
        if (position == layoutPosition) {
            holder.rbOption.setChecked(true);
        } else {
            holder.rbOption.setChecked(false);
        }

    }

    @Override
    public int getItemCount() {
        return listOptions.size();
    }


    public OnItemClickListenter getOnItemClickListenter() {
        return mOnItemClickListenter;
    }

    public void setOnItemClickListenter(OnItemClickListenter onItemClickListenter) {
        mOnItemClickListenter = onItemClickListenter;
    }
}
